package io.petstore.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PetDtoResponse {

    //Only store fields those I am changing in request
    public Integer id;
    public String name;

}