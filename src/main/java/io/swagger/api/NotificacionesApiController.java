package io.swagger.api;

import io.swagger.model.Devolver;
import io.swagger.model.NotificacionError;
import io.swagger.model.NotificacionPresenciaSala;
import io.swagger.model.NotificacionUsuarioValido;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import service.SendEmail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-02T00:36:42.320Z[GMT]")
@RestController
public class NotificacionesApiController implements NotificacionesApi {

    private static final Logger log = LoggerFactory.getLogger(NotificacionesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    String login= "root";
    String password = "8AIAGUzOgTrzHZDxQg1P";

    @org.springframework.beans.factory.annotation.Autowired
    public NotificacionesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Devolver> notificarError(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "restKey", required = true) String restKey,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody NotificacionError body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Devolver>(objectMapper.readValue("{\n  \"codigo\" : 200,\n  \"mensaje\" : \"message\"\n}", Devolver.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Devolver>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Devolver>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Devolver> notificarPresenciaSala(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "restKey", required = true) String restKey,@Parameter(in = ParameterIn.DEFAULT, description = "nombreSala", required=true, schema=@Schema()) @Valid @RequestBody NotificacionPresenciaSala body) {
        String accept = request.getHeader("Accept");
        ArrayList<String> emails = new ArrayList<>();
        if (accept != null && accept.contains("application/json")) {
            try {
                if (service.serviceClass.restKeyChecker(restKey))
                {
                    try {
                        Connection con = DriverManager.getConnection (
                                "jdbc:mysql://localhost:3306/mtis", login, password);
                        Statement stmt = con.createStatement();
                        ResultSet result = stmt.executeQuery("SELECT empleados.email, salas.nombre " +
                                        "FROM ((empleados " +
                                        "INNER JOIN controlpresencia ON empleados.nif=controlpresencia.nif)" +
                                        "INNER JOIN salas ON controlpresencia.codigoSala=salas.codigoSala) " +
                                        "WHERE salas.nombre ='" + body.getNombreSala() + "';");

                        while(result.next())
                        {
                            emails.add(result.getString("empleados.email"));
                        }
                        for (int i =0; i<emails.size(); i++)
                        {
                            String to = emails.get(i);
                            SendEmail.send(to);
                        }


                    } catch(SQLException e){
                        System.out.println("SQL exception occured" + e);

                    }

                }
                return new ResponseEntity<Devolver>(objectMapper.readValue("{\n   \"type\" : \"Devolver\",\n  \"codigo\" : 200,\n  \"mensaje\" : \"message\"\n}", Devolver.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Devolver>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Devolver>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Devolver> notificarUsuarioNoValido(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "restKey", required = true) String restKey,@Parameter(in = ParameterIn.DEFAULT, description = "nif", required=true, schema=@Schema()) @Valid @RequestBody NotificacionUsuarioValido body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Devolver>(objectMapper.readValue("{\n  \"codigo\" : 200,\n  \"mensaje\" : \"message\"\n}", Devolver.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Devolver>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Devolver>(HttpStatus.NOT_IMPLEMENTED);
    }

}
