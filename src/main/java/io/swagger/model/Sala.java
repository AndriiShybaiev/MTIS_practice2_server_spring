package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Sala
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-02T00:36:42.320Z[GMT]")


public class Sala  implements OneOfinlineResponse200 {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("codigoSala")
  private String codigoSala = null;

  @JsonProperty("nombre")
  private String nombre = null;

  @JsonProperty("nivel")
  private Integer nivel = null;

  public Sala id(Integer id) {
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

  public Sala codigoSala(String codigoSala) {
    this.codigoSala = codigoSala;
    return this;
  }

  /**
   * Get codigoSala
   * @return codigoSala
   **/
  @Schema(example = "code here", required = true, description = "")
      @NotNull

    public String getCodigoSala() {
    return codigoSala;
  }

  public void setCodigoSala(String codigoSala) {
    this.codigoSala = codigoSala;
  }

  public Sala nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Get nombre
   * @return nombre
   **/
  @Schema(example = "name", required = true, description = "")
      @NotNull

    public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Sala nivel(Integer nivel) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sala sala = (Sala) o;
    return Objects.equals(this.id, sala.id) &&
        Objects.equals(this.codigoSala, sala.codigoSala) &&
        Objects.equals(this.nombre, sala.nombre) &&
        Objects.equals(this.nivel, sala.nivel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, codigoSala, nombre, nivel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sala {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    codigoSala: ").append(toIndentedString(codigoSala)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    nivel: ").append(toIndentedString(nivel)).append("\n");
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
