package com.beer.brewery.dto.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import com.beer.brewery.model.TypeBeer;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class TypeBeerResponseDTO implements Serializable {
    private final Long id;
    private final String type;

    public TypeBeerResponseDTO(TypeBeer tb) {
        this.id = tb.getId();
        this.type = tb.getType();
    }
}
