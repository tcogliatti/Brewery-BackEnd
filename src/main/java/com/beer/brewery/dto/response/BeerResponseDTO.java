package com.beer.brewery.dto.response;

import com.beer.brewery.model.TypeBeer;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import com.beer.brewery.model.Beer;

import java.io.Serializable;
import java.util.Date;

@Data
@RequiredArgsConstructor
public class BeerResponseDTO implements Serializable {
    private final Long id;
    private final String name;
    private final TypeBeerResponseDTO type;
    private final float price;
    private final Integer stock;
    private final String image;
    private final Date createdAt;
    private final boolean clearance;

    public BeerResponseDTO(Beer b) {
        this.id = b.getId();
        this.createdAt = b.getCreatedAt();
        this.type = new TypeBeerResponseDTO(b.getType());
        this.price = b.getPrice();
        this.stock = b.getStock();
        this.image = b.getImage();
        this.clearance = b.isClearance();
        this.name = b.getName();
    }
}
