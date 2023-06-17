package com.works.services;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;

    public Product save( Product product ) {
        return productRepository.save(product);
    }

    public ResponseEntity list() {
        return new ResponseEntity(productRepository.proCatJoin(), HttpStatus.OK);
    }


}
