package com.beer.brewery.repository;

import com.beer.brewery.model.TypeBeer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepo extends JpaRepository<TypeBeer, Long> {
}
