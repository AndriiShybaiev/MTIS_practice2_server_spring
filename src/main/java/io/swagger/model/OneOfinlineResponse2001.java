package io.swagger.model;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
/**
* OneOfinlineResponse2001
*/
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.PROPERTY,
  property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = Nivel.class, name = "Nivel"),
  @JsonSubTypes.Type(value = Devolver.class, name = "Devolver")
})
public interface OneOfinlineResponse2001 {

}
