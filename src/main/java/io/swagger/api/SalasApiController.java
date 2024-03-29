package io.swagger.api;

import io.swagger.model.Devolver;
import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse2001;
import io.swagger.model.Sala;
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

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-02T00:36:42.320Z[GMT]")
@RestController
public class SalasApiController implements SalasApi {

    private static final Logger log = LoggerFactory.getLogger(SalasApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    String login= "root";
    String password = "8AIAGUzOgTrzHZDxQg1P";

    @org.springframework.beans.factory.annotation.Autowired
    public SalasApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Devolver> addSala(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "restKey", required = true) String restKey,@Parameter(in = ParameterIn.DEFAULT, description = "Salas", required=true, schema=@Schema()) @Valid @RequestBody Sala body) {
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
                        String codigoSala = body.getCodigoSala();
                        String nombre = body.getNombre();
                        Integer nivel = body.getNivel();
                        rs = stmt.executeUpdate ("INSERT INTO salas (codigoSala, nivel, nombre) VALUES ('" + codigoSala + "', " + nivel + ", " + "'" + nombre +"')");
                        Devolver dv = new Devolver();
                        dv.setCodigo(0);
                        dv.setMensaje("ok");
                        return new ResponseEntity<Devolver>(objectMapper.readValue("{\n  \"type\" : \"Devolver\",\n \"codigo\" : 200,\n  \"mensaje\" : \"message\"\n}", Devolver.class), HttpStatus.OK);
                    } catch(SQLException e){
                        System.out.println("SQL exception occured" + e);

                    }
                }
                return new ResponseEntity<Devolver>(objectMapper.readValue("{\n  \"codigo\" : 200,\n  \"mensaje\" : \"message\"\n}", Devolver.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Devolver>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Devolver>(HttpStatus.NOT_IMPLEMENTED);
    }


    public ResponseEntity<Devolver> deleteSala(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("idCodigoSala") String idCodigoSala,@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "restKey", required = true) String restKey) {
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
                        rs = stmt.executeUpdate("DELETE FROM salas WHERE codigoSala=" + "'"+ idCodigoSala + "';");
                        return new ResponseEntity<Devolver>(objectMapper.readValue("{\n  \"type\" : \"Devolver\",\n \"codigo\" : 200,\n  \"mensaje\" : \"message\"\n}", Devolver.class), HttpStatus.OK);
                    } catch(SQLException e){
                        System.out.println("SQL exception occured" + e);

                    }
                }
                return new ResponseEntity<Devolver>(objectMapper.readValue("{\n  \"codigo\" : 200,\n  \"mensaje\" : \"message\"\n}", Devolver.class), HttpStatus.NOT_IMPLEMENTED);            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Devolver>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Devolver>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse200> searchSala(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("idCodigoSala") String idCodigoSala,@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "restKey", required = true) String restKey) {
        String accept = request.getHeader("Accept");
        Integer rs=1;
        String nombre = "";
        Integer nivel=0;
        if (accept != null && accept.contains("application/json")) {
            try {
                if (service.serviceClass.restKeyChecker(restKey))
                {
                    try {
                        Connection con = DriverManager.getConnection (
                                "jdbc:mysql://localhost:3306/mtis", login, password);
                        Statement stmt = con.createStatement();
                        ResultSet result = stmt.executeQuery("SELECT * FROM salas WHERE codigoSala = " + "'"+ idCodigoSala + "';");

                        while(result.next())
                        {
                            nivel = result.getInt("salas.nivel");
                            nombre = result.getString("salas.nombre");
                        }

                    } catch(SQLException e){
                        System.out.println("SQL exception occured" + e);

                    }
                }
                InlineResponse200 response = new InlineResponse200();
                response.setNivel(nivel);
                response.setCodigoSala(idCodigoSala);
                response.setNombre(nombre);
                response.toString();
                return new ResponseEntity<InlineResponse200>(objectMapper.readValue(response.toString(), InlineResponse200.class), HttpStatus.OK);            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse200>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse200>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Devolver> updateSala(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "restKey", required = true) String restKey,@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("idCodigoSala") String idCodigoSala,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Sala body) {
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
                        String test = "UPDATE salas SET nombre = '" + body.getNombre() + "', " +
                                "nivel = " + body.getNivel()
                                + " WHERE codigoSala ='" + body.getCodigoSala() + "';";
                        rs = stmt.executeUpdate("UPDATE salas SET nombre = '" + body.getNombre() + "', " +
                            "nivel =" + body.getNivel()
                                + " WHERE codigoSala ='" + body.getCodigoSala() + "';"
                        );
                    } catch(SQLException e){
                        System.out.println("SQL exception occured" + e);

                    }
                }
                return new ResponseEntity<Devolver>(objectMapper.readValue("{\n  \"type\" : \"Devolver\",\n \"codigo\" : 200,\n  \"mensaje\" : \"update ok\"\n}", Devolver.class), HttpStatus.OK);            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Devolver>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Devolver>(HttpStatus.NOT_IMPLEMENTED);
    }

}
