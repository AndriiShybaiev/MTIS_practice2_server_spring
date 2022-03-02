package io.swagger.model;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
/**
* OneOfinlineResponse2002
*/
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.PROPERTY,
  property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = Dispositivo.class, name = "Dispositivo"),
  @JsonSubTypes.Type(value = Devolver.class, name = "Devolver")
})
public interface OneOfinlineResponse2002 {

}
