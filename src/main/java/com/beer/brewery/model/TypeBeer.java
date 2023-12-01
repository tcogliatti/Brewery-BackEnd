package com.beer.brewery.model;

import com.beer.brewery.dto.request.TypeBeerRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter

public class TypeBeer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idType")
    private Long id;
    @Column
    private String type;

    public TypeBeer() {
    }

    public TypeBeer(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public TypeBeer(TypeBeerRequestDTO tbr) {
        this.type = tbr.getType();
    }
}
