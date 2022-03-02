package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Devolver
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-02T00:36:42.320Z[GMT]")


public class Devolver  implements OneOfinlineResponse200, OneOfinlineResponse2001, OneOfinlineResponse2002 {
  @JsonProperty("mensaje")
  private String mensaje = null;

  @JsonProperty("codigo")
  private Integer codigo = null;

  public Devolver mensaje(String mensaje) {
    this.mensaje = mensaje;
    return this;
  }

  /**
   * Get mensaje
   * @return mensaje
   **/
  @Schema(example = "message", required = true, description = "")
      @NotNull

    public String getMensaje() {
    return mensaje;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }

  public Devolver codigo(Integer codigo) {
    this.codigo = codigo;
    return this;
  }

  /**
   * Get codigo
   * @return codigo
   **/
  @Schema(example = "200", required = true, description = "")
      @NotNull

    public Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Devolver devolver = (Devolver) o;
    return Objects.equals(this.mensaje, devolver.mensaje) &&
        Objects.equals(this.codigo, devolver.codigo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mensaje, codigo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Devolver {\n");
    
    sb.append("    mensaje: ").append(toIndentedString(mensaje)).append("\n");
    sb.append("    codigo: ").append(toIndentedString(codigo)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
