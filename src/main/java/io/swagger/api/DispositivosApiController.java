package io.swagger.api;

import io.swagger.model.Devolver;
import io.swagger.model.Dispositivo;
import io.swagger.model.InlineResponse2002;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-02T00:36:42.320Z[GMT]")
@RestController
public class DispositivosApiController implements DispositivosApi {

    String login= "root";
    String password = "8AIAGUzOgTrzHZDxQg1P";

    private static final Logger log = LoggerFactory.getLogger(DispositivosApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public DispositivosApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Devolver> addDispositivo(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "restKey", required = true) String restKey,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Dispositivo body) {
        Integer rs=1;
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                if (service.serviceClass.restKeyChecker(restKey))
                {
                    try {
                        Connection con = DriverManager.getConnection (
                                "jdbc:mysql://localhost:3306/mtis", login, password);
                        Statement stmt = con.createStatement();
                        String descr = body.getDescripcion();
                        Integer code = body.getCodigo();
                        rs = stmt.executeUpdate ("INSERT INTO dispositivo (codigo, descripcion) VALUES (" + code + ", " + "'" + descr +"')");
                        Devolver dv = new Devolver();
                        dv.setCodigo(0);
                        dv.setMensaje("ok");
                        return new ResponseEntity<Devolver>(objectMapper.readValue("{\n  \"type\" : \"Devolver\",\n \"codigo\" : 200,\n  \"mensaje\" : \"message\"\n}", Devolver.class), HttpStatus.OK);
                    } catch(SQLException e){
                        System.out.println("SQL exception occured" + e);

                    }
                }
                return new ResponseEntity<Devolver>(objectMapper.readValue("{\n \"type\" : \"Devolver\",\n \"codigo\" : 403,\n  \"mensaje\" : \"wrong rest key\"\n}", Devolver.class), HttpStatus.FORBIDDEN);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Devolver>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Devolver>(HttpStatus.NOT_IMPLEMENTED);
    }


    public ResponseEntity<Devolver> deleteDispositivo(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("idDispositivo") String idDispositivo,@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "restKey", required = true) String restKey) {
        String accept = request.getHeader("Accept");
        Integer rs=1;
        if (accept != null && accept.contains("application/json")) {
            try {
                if (service.serviceClass.restKeyChecker(restKey))
                {
                    try {
                        Connection con = DriverManager.getConnection (
                                "jdbc:mysql://localhost:3306/mtis", login, password);
                        Statement stmt = con.createStatement();
                        rs = stmt.executeUpdate("DELETE FROM dispositivo WHERE codigo=" + idDispositivo + ";");
                        return new ResponseEntity<Devolver>(objectMapper.readValue("{\n  \"type\" : \"Devolver\",\n \"codigo\" : 200,\n  \"mensaje\" : \"message\"\n}", Devolver.class), HttpStatus.OK);
                    } catch(SQLException e){
                        System.out.println("SQL exception occured" + e);

                    }
                }
                return new ResponseEntity<Devolver>(objectMapper.readValue("{\n \"type\" : \"Devolver\",\n \"codigo\" : 403,\n  \"mensaje\" : \"wrong rest key\"\n}", Devolver.class), HttpStatus.FORBIDDEN);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Devolver>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Devolver>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse2002> searchDispositivo(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("idDispositivo") String idDispositivo,@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "restKey", required = true) String restKey) {
        String accept = request.getHeader("Accept");
        Integer rs=1;
        Integer codigo=0;
        String descripcion = "";
        if (accept != null && accept.contains("application/json")) {
            try {
                if (service.serviceClass.restKeyChecker(restKey))
                {
                    try {
                        Connection con = DriverManager.getConnection (
                                "jdbc:mysql://localhost:3306/mtis", login, password);
                        Statement stmt = con.createStatement();
                        ResultSet result = stmt.executeQuery("SELECT * FROM dispositivo WHERE " + "codigo = " + idDispositivo + ";");

                        while(result.next())
                        {
                            codigo = result.getInt("dispositivo.codigo");
                            descripcion = result.getString("dispositivo.descripcion");
                        }

                    } catch(SQLException e){
                        System.out.println("SQL exception occured" + e);

                    }
                }
                InlineResponse2002 response = new InlineResponse2002();
                response.setCodigo(codigo);
                response.setDescripcion(descripcion);
                response.toString();
                return new ResponseEntity<InlineResponse2002>(objectMapper.readValue(response.toString(), InlineResponse2002.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2002>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2002>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Devolver> updateDispositivo(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "restKey", required = true) String restKey,@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("idDispositivo") String idDispositivo,@Parameter(in = ParameterIn.DEFAULT, description = "Salas", required=true, schema=@Schema()) @Valid @RequestBody Dispositivo body) {
        String accept = request.getHeader("Accept");
        Integer rs=1;
        if (accept != null && accept.contains("application/json")) {
            try {
                if (service.serviceClass.restKeyChecker(restKey))
                {
                    try {
                        Connection con = DriverManager.getConnection (
                                "jdbc:mysql://localhost:3306/mtis", login, password);
                        Statement stmt = con.createStatement();
                        rs = stmt.executeUpdate("UPDATE dispositivo SET descripcion = '" + body.getDescripcion() + "' "
                                + "WHERE codigo=" + body.getCodigo() + ";"
                        );
                    } catch(SQLException e){
                        System.out.println("SQL exception occured" + e);

                    }
                }
                return new ResponseEntity<Devolver>(objectMapper.readValue("{\n  \"type\" : \"Devolver\",\n \"codigo\" : 200,\n  \"mensaje\" : \"update ok\"\n}", Devolver.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Devolver>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Devolver>(HttpStatus.NOT_IMPLEMENTED);
    }

}
