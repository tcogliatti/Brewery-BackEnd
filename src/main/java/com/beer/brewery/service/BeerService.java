package com.beer.brewery.service;

import com.beer.brewery.dto.request.BeerRequestDTO;
import com.beer.brewery.dto.response.BeerResponseDTO;
import com.beer.brewery.exceptions.NotFoundEntity;
import lombok.RequiredArgsConstructor;
import com.beer.brewery.model.Beer;
import com.beer.brewery.model.TypeBeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.beer.brewery.repository.BeerRepo;
import com.beer.brewery.repository.TypeRepo;

import java.util.List;

@Service("BeerService")
@RequiredArgsConstructor
public class BeerService {
    @Autowired
    private final BeerRepo br;
    @Autowired
    private final TypeRepo tbr;

    public List<BeerResponseDTO> findAll() {
        List<BeerResponseDTO> result = this.br.findAll().stream().map(b -> new BeerResponseDTO(b)).toList();
        return result;
    }

    public BeerResponseDTO findById(Long id) {
        return this.br.findById(id)
                .map(b -> new BeerResponseDTO(b))
                .orElseThrow(() -> new NotFoundEntity("Beer", id));
    }

    @Transactional
    public BeerResponseDTO save(BeerRequestDTO request) {
        TypeBeer tb = this.tbr.findById(request.getType())
                .orElseThrow(() -> new NotFoundEntity("TypeBeer", request.getType()));
        final var b = new Beer(request);
        b.setType(tb);
        br.save(b);
        return new BeerResponseDTO(b);
    }
    @Transactional
    public BeerResponseDTO update(BeerRequestDTO request, Long id) {
        findById(id);
        TypeBeer tb = this.tbr.findById(request.getType())
                .orElseThrow(() -> new NotFoundEntity("TypeBeer", request.getType()));
        final var b = new Beer(request);
        b.setType(tb);
        br.save(b);
        return new BeerResponseDTO(b);
    }
    @Transactional
    public void deleteById(Long id) {
        br.deleteById(id);
    }
}
