package com.beer.brewery.repository;

import com.beer.brewery.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepo extends JpaRepository<Beer, Long> {
}
