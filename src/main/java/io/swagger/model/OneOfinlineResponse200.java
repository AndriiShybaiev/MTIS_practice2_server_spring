package io.swagger.model;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
/**
* OneOfinlineResponse200
*/
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.PROPERTY,
  property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = Sala.class, name = "Sala"),
  @JsonSubTypes.Type(value = Devolver.class, name = "Devolver")
})
public interface OneOfinlineResponse200 {

}
