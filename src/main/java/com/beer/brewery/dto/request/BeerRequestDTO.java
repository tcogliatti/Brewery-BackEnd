package com.beer.brewery.dto.request;

import com.beer.brewery.model.TypeBeer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class BeerRequestDTO implements Serializable {
    private String name;
    private Long type;
    private float price;
    private Integer stock;
    private String image;
    private Date createdAt;
    private boolean clearance;
}
