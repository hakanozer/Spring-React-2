package com.works.services;

import com.works.configs.Rest;
import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository repository;
    final RestTemplate rs1;

    public ResponseEntity save(Product product) {
        try {
            repository.save(product);
            Rest rest = new Rest(true, product);
            return new ResponseEntity(rest, HttpStatus.OK);
        } catch (Exception ex) {
            Rest rest = new Rest(false, ex.getMessage());
            return new ResponseEntity(rest, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity list() {
        Rest rest = new Rest(true, repository.findAll());
        return new ResponseEntity(rest, HttpStatus.OK);
    }

}