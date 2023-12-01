package com.beer.brewery.controller;

import com.beer.brewery.dto.request.TypeBeerRequestDTO;
import com.beer.brewery.dto.response.TypeBeerResponseDTO;
import com.beer.brewery.exceptions.NotFoundEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.beer.brewery.service.TypeBeerService;

import java.util.List;

@RestController
@RequestMapping("api/type")
public class TypeBeerController {
    @Autowired
    private TypeBeerService tbs;

    @GetMapping("")
    public List<TypeBeerResponseDTO> findAll() {
        System.out.println("entro");
        return this.tbs.findAll();
    }

    @GetMapping("/{id}")
    public TypeBeerResponseDTO findById(@PathVariable Long id) {
        return this.tbs.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<TypeBeerResponseDTO> save(@RequestBody @Validated TypeBeerRequestDTO request) {
        final var result = this.tbs.save(request);
        return ResponseEntity.accepted().body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeBeerResponseDTO> update(@RequestBody @Validated TypeBeerRequestDTO request, @PathVariable Long id) {
        try {
            final var result = this.tbs.update(request, id);
            return ResponseEntity.accepted().body(result);
        } catch (Exception e) {
            throw new NotFoundEntity("Type Beer", id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleByid(@PathVariable Long id){
        this.tbs.deleteById(id);
    }
}
