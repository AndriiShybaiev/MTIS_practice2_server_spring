package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * NotificacionPresenciaSala
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-02T00:36:42.320Z[GMT]")


public class NotificacionPresenciaSala   {
  @JsonProperty("nombreSala")
  private String nombreSala = null;

  public NotificacionPresenciaSala nombreSala(String nombreSala) {
    this.nombreSala = nombreSala;
    return this;
  }

  /**
   * Get nombreSala
   * @return nombreSala
   **/
  @Schema(example = "something", required = true, description = "")
      @NotNull

    public String getNombreSala() {
    return nombreSala;
  }

  public void setNombreSala(String nombreSala) {
    this.nombreSala = nombreSala;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NotificacionPresenciaSala notificacionPresenciaSala = (NotificacionPresenciaSala) o;
    return Objects.equals(this.nombreSala, notificacionPresenciaSala.nombreSala);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombreSala);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotificacionPresenciaSala {\n");
    
    sb.append("    nombreSala: ").append(toIndentedString(nombreSala)).append("\n");
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
