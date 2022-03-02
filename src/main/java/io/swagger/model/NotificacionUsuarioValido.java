package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * NotificacionUsuarioValido
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-02T00:36:42.320Z[GMT]")


public class NotificacionUsuarioValido   {
  @JsonProperty("nif")
  private String nif = null;

  public NotificacionUsuarioValido nif(String nif) {
    this.nif = nif;
    return this;
  }

  /**
   * Get nif
   * @return nif
   **/
  @Schema(example = "somenif", required = true, description = "")
      @NotNull

    public String getNif() {
    return nif;
  }

  public void setNif(String nif) {
    this.nif = nif;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NotificacionUsuarioValido notificacionUsuarioValido = (NotificacionUsuarioValido) o;
    return Objects.equals(this.nif, notificacionUsuarioValido.nif);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nif);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotificacionUsuarioValido {\n");
    
    sb.append("    nif: ").append(toIndentedString(nif)).append("\n");
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
