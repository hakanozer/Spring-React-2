package com.works.services;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;

    public Product save( Product product ) {
        return productRepository.save(product);
    }

    public List<Product> allProduct() {
        return productRepository.findAll();
    }

    public boolean productDelete( String stPid ) {
        try {
            long pid = Long.parseLong(stPid);
            boolean status = productRepository.existsById(pid);
            if ( status ) {
                productRepository.deleteById(pid);
                return true;
            }
        }catch (Exception ex) { }
        return  false;
    }

    public Product getSingleProduct( Long pid ) {
        Optional<Product> optionalProduct = productRepository.findById(pid);
        if ( optionalProduct.isPresent() ){
            return optionalProduct.get();
        }
        return null;
    }

    public boolean updateProduct( Product product ) {
        try {
            productRepository.saveAndFlush(product);
            return true;
        }catch (Exception ex) {
            return false;
        }
    }

}
