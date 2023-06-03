package com.work.service;

import com.work.entities.Product;
import com.work.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {
    final ProductRepository productRepository;


    public List<Product> searchList (String search){
        return productRepository.findByTitleLikeIgnoreCase(search);
    }

}
