package io.swagger.api;

import io.swagger.model.Devolver;
import io.swagger.model.InlineResponse2001;
import io.swagger.model.InlineResponse2002;
import io.swagger.model.Nivel;
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
public class NivelesApiController implements NivelesApi {

    String login= "root";
    String password = "8AIAGUzOgTrzHZDxQg1P";

    private static final Logger log = LoggerFactory.getLogger(NivelesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public NivelesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Devolver> deleteNivel(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("idNivel") String idNivel,@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "restKey", required = true) String restKey) {
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
                        rs = stmt.executeUpdate("DELETE FROM niveles WHERE nivel=" + idNivel + ";");
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

    public ResponseEntity<InlineResponse2001> searchNivel(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("idNivel") String idNivel,@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "restKey", required = true) String restKey) {
        String accept = request.getHeader("Accept");
        Integer rs=1;
        Integer nivel=0;
        String descripcion = "";
        if (accept != null && accept.contains("application/json")) {
            try {
                if (service.serviceClass.restKeyChecker(restKey))
                {
                    try {
                        Connection con = DriverManager.getConnection (
                                "jdbc:mysql://localhost:3306/mtis", login, password);
                        Statement stmt = con.createStatement();
                        ResultSet result = stmt.executeQuery("SELECT * FROM niveles WHERE " + "nivel = " + idNivel + ";");

                        while(result.next())
                        {
                            nivel = result.getInt("niveles.nivel");
                            descripcion = result.getString("niveles.descripcion");
                        }

                    } catch(SQLException e){
                        System.out.println("SQL exception occured" + e);

                    }
                }
                InlineResponse2001 response = new InlineResponse2001();
                response.setNivel(nivel);
                response.setDescripcion(descripcion);
                response.toString();
                return new ResponseEntity<InlineResponse2001>(objectMapper.readValue(response.toString(), InlineResponse2001.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2001>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2001>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Devolver> updateNivel(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "restKey", required = true) String restKey,@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("idNivel") String idNivel,@Parameter(in = ParameterIn.DEFAULT, description = "Nivel", required=true, schema=@Schema()) @Valid @RequestBody Nivel body) {
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
                        rs = stmt.executeUpdate("UPDATE niveles SET descripcion = '" + body.getDescripcion() + "' "
                                + "WHERE nivel=" + body.getNivel() + ";"
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
