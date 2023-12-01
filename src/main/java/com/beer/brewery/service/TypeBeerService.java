package com.beer.brewery.service;

import com.beer.brewery.dto.request.TypeBeerRequestDTO;
import com.beer.brewery.dto.response.TypeBeerResponseDTO;
import com.beer.brewery.exceptions.NotFoundEntity;
import lombok.RequiredArgsConstructor;
import com.beer.brewery.model.TypeBeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.beer.brewery.repository.TypeRepo;

import java.util.List;

@Service("TypeBeerService")
@RequiredArgsConstructor
public class TypeBeerService {
    @Autowired
    private final TypeRepo tr;

    public List<TypeBeerResponseDTO> findAll() {
        List<TypeBeerResponseDTO> response = this.tr.findAll().stream().
                map(TypeBeerResponseDTO::new).toList();
        return response;
    }

    public TypeBeerResponseDTO findById(Long id) {
        return this.tr.findById(id).map(TypeBeerResponseDTO::new)
                .orElseThrow(() -> new NotFoundEntity("Type of Beer", id));
    }
    @Transactional
    public TypeBeerResponseDTO save(TypeBeerRequestDTO request) {
        TypeBeer tb = new TypeBeer(request);
        tr.save(tb);
        return new TypeBeerResponseDTO(tb);
    }

    @Transactional
    public TypeBeerResponseDTO update(TypeBeerRequestDTO request, Long id) {
        try {
            findById(id);
            TypeBeer tb = new TypeBeer(id, request.getType());
            tr.save(tb);
            return new TypeBeerResponseDTO(tb);
        } catch (Exception e) {
            throw new NotFoundEntity("Type Beer", id);
        }
    }

    @Transactional
    public void deleteById(Long id) {
        tr.deleteById(id);
    }
}
