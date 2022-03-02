package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Nivel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-02T00:36:42.320Z[GMT]")


public class Nivel  implements OneOfinlineResponse2001 {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("nivel")
  private Integer nivel = null;

  @JsonProperty("descripcion")
  private String descripcion = null;

  public Nivel id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(example = "1", required = true, description = "")
      @NotNull

    public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Nivel nivel(Integer nivel) {
    this.nivel = nivel;
    return this;
  }

  /**
   * Get nivel
   * @return nivel
   **/
  @Schema(example = "1", required = true, description = "")
      @NotNull

    public Integer getNivel() {
    return nivel;
  }

  public void setNivel(Integer nivel) {
    this.nivel = nivel;
  }

  public Nivel descripcion(String descripcion) {
    this.descripcion = descripcion;
    return this;
  }

  /**
   * Get descripcion
   * @return descripcion
   **/
  @Schema(example = "ground floor", required = true, description = "")
      @NotNull

    public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Nivel nivel = (Nivel) o;
    return Objects.equals(this.id, nivel.id) &&
        Objects.equals(this.nivel, nivel.nivel) &&
        Objects.equals(this.descripcion, nivel.descripcion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nivel, descripcion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Nivel {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nivel: ").append(toIndentedString(nivel)).append("\n");
    sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
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
