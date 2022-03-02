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

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-02T00:36:42.320Z[GMT]")
@RestController
public class DispositivosApiController implements DispositivosApi {

    private static final Logger log = LoggerFactory.getLogger(DispositivosApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public DispositivosApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Devolver> addDispositivo(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "restKey", required = true) String restKey,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Dispositivo body) {
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

    public ResponseEntity<List<Dispositivo>> allDispositivos(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "restKey", required = true) String restKey) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Dispositivo>>(objectMapper.readValue("[ {\n  \"descripcion\" : \"printwer\",\n  \"codigo\" : 1,\n  \"id\" : 1\n}, {\n  \"descripcion\" : \"printwer\",\n  \"codigo\" : 1,\n  \"id\" : 1\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Dispositivo>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Dispositivo>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Devolver> deleteDispositivo(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("idDispositivo") String idDispositivo,@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "restKey", required = true) String restKey) {
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

    public ResponseEntity<InlineResponse2002> searchDispositivo(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("idDispositivo") String idDispositivo,@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "restKey", required = true) String restKey) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse2002>(objectMapper.readValue("\"\"", InlineResponse2002.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2002>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2002>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Devolver> updateDispositivo(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "restKey", required = true) String restKey,@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("idDispositivo") String idDispositivo,@Parameter(in = ParameterIn.DEFAULT, description = "Salas", required=true, schema=@Schema()) @Valid @RequestBody Dispositivo body) {
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
