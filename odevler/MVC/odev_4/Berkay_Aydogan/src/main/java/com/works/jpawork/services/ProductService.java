package com.works.jpawork.services;

import com.works.jpawork.entities.Product;
import com.works.jpawork.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;

    public List<Product> productList() {
        if (productRepository.findAll() == null) {
            return null;
        } else {
            return productRepository.findAll();
        }
    }

    public Product saveProduct(Product product){
       return productRepository.save(product);
    }

    public Product searchProduct(String q){
       return productRepository.findByTitleLikeIgnoreCaseOrDetailLikeIgnoreCase(q,q);
    }

    public void deleteProduct(String id){
        try{
            long Id = Long.parseLong(id);
            productRepository.deleteById(Id);
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }

    public void updateProduct(Product product){
        productRepository.updateProduct(product.getTitle(),product.getPrice(),product.getStock(),product.getDetail());
    }
}