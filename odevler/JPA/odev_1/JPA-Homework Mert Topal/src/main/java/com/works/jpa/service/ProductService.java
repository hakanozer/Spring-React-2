package com.works.jpa.service;

import com.works.jpa.entities.Product;
import com.works.jpa.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;

    public Product save(Product product){
        return productRepository.save(product);
    }

    public List<Product> allProduct(Product products){
        return productRepository.findAll();
    }

    public boolean deleteProduct(String stPid){
        try {
            long pid = Long.parseLong(stPid);
            boolean status = productRepository.existsById(pid);
            if(status){
                productRepository.deleteById(pid);
                return true;
            }
        }catch (Exception exception){
            System.err.println(exception);
        }
        return false;
    }

}
