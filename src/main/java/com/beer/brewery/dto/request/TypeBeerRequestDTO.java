package com.beer.brewery.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties
public class TypeBeerRequestDTO implements Serializable {
    private String type;
}
