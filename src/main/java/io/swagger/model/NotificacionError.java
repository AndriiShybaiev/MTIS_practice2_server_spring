package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Devolver;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * NotificacionError
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-02T00:36:42.320Z[GMT]")


public class NotificacionError   {
  @JsonProperty("error")
  private String error = null;

  @JsonProperty("nif")
  private String nif = null;

  @JsonProperty("devolver")
  private Devolver devolver = null;

  public NotificacionError error(String error) {
    this.error = error;
    return this;
  }

  /**
   * Get error
   * @return error
   **/
  @Schema(example = "Error", required = true, description = "")
      @NotNull

    public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public NotificacionError nif(String nif) {
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

  public NotificacionError devolver(Devolver devolver) {
    this.devolver = devolver;
    return this;
  }

  /**
   * Get devolver
   * @return devolver
   **/
  @Schema(description = "")
  
    @Valid
    public Devolver getDevolver() {
    return devolver;
  }

  public void setDevolver(Devolver devolver) {
    this.devolver = devolver;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NotificacionError notificacionError = (NotificacionError) o;
    return Objects.equals(this.error, notificacionError.error) &&
        Objects.equals(this.nif, notificacionError.nif) &&
        Objects.equals(this.devolver, notificacionError.devolver);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error, nif, devolver);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotificacionError {\n");
    
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    nif: ").append(toIndentedString(nif)).append("\n");
    sb.append("    devolver: ").append(toIndentedString(devolver)).append("\n");
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
