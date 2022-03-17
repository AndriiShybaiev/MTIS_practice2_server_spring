package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InlineResponse200
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-02T00:36:42.320Z[GMT]")


public class InlineResponse200  implements OneOfinlineResponse200 {

  public Integer getNivel() {
    return nivel;
  }

  public void setNivel(Integer nivel) {
    this.nivel = nivel;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCodigoSala() {
    return codigoSala;
  }

  public void setCodigoSala(String codigoSala) {
    this.codigoSala = codigoSala;
  }

  @JsonProperty("nivel")
  private Integer nivel = null;

  @JsonProperty("nombre")
  private String nombre = null;

  @JsonProperty("codigoSala")
  private String codigoSala = null;


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n  \"type\": \"InlineResponse200\"\n,");
    sb.append("    \"nivel\": ").append(toIndentedString(nivel)).append(",\n");
    sb.append("    \"nombre\": ").append("\"").append(toIndentedString(nombre)).append("\",\n");
    sb.append("    \"codigoSala\": ").append("\"").append(toIndentedString(codigoSala)).append("\"\n");
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
