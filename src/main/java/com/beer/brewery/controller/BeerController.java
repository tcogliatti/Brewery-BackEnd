package com.beer.brewery.controller;

import com.beer.brewery.dto.request.BeerRequestDTO;
import com.beer.brewery.dto.response.BeerResponseDTO;
import com.beer.brewery.exceptions.NotFoundEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.beer.brewery.service.BeerService;

import java.util.List;

@RestController
@RequestMapping("api/beer")
public class BeerController {
    @Autowired
    private BeerService bs;

    @GetMapping("")
    public List<BeerResponseDTO> findAll() {
        System.out.println("entro");
        return this.bs.findAll();
    }
    @GetMapping("/{id}")
    public BeerResponseDTO findById(@PathVariable Long id) {
        return this.bs.findById(id);
    }
    @PostMapping("")
    public ResponseEntity<BeerResponseDTO> save(@RequestBody @Validated BeerRequestDTO request) {
        final var result = this.bs.save(request);
        return ResponseEntity.accepted().body(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<BeerResponseDTO> update(@RequestBody @Validated BeerRequestDTO request, @PathVariable Long id) {
        try {
            final var result = this.bs.update(request, id);
            return ResponseEntity.accepted().body(result);
        } catch (Exception e) {
            throw new NotFoundEntity("Beer", id);
        }
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        this.bs.deleteById(id);
    }

}
