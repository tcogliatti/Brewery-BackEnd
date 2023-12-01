package com.beer.brewery.model;

import com.beer.brewery.dto.request.BeerRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Getter
@Setter
public class Beer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idBeer")
    private Long id;
    @Column
    private String name;
    @Column
    private Date createdAt;
    @ManyToOne
    private TypeBeer type;
    @Column
    private float price;
    @Column
    private Integer stock;
    @Column
    private String image;
    @Column
    private boolean clearance;

    public Beer() {
    }

    public Beer(Long id, String name, Date createdAt, TypeBeer type, float price, Integer stock, String image, boolean clearance) {
        this.id = id;
        this.createdAt = createdAt;
        this.type = type;
        this.price = price;
        this.stock = stock;
        this.image = image;
        this.clearance = clearance;
        this.name = name;
    }

    public Beer(BeerRequestDTO b) {
        this.createdAt = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        this.type = null;
        this.price = b.getPrice();
        this.stock = b.getStock();
        this.image = b.getImage();
        this.clearance = b.isClearance();
        this.name = b.getName();
    }
}
