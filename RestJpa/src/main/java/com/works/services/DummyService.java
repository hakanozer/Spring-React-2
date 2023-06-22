package com.works.services;

import com.works.models.Product;
import com.works.models.Products;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class DummyService {

    final RestTemplate restTemplate;

    public Products getAllProduct() {
        String url = "https://dummyjson.com/products";
        Products obj = restTemplate.getForObject(url, Products.class);
        String title = obj.getProducts().get(0).getTitle();
        System.out.println(title);
        return obj;
    }

    public Product addProduct(Product product) {
        String url = "https://dummyjson.com/products/add";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity httpEntity = new HttpEntity(product, httpHeaders);

        ResponseEntity<Product> responseEntity = restTemplate.postForEntity(url,httpEntity, Product.class );
        return responseEntity.getBody();
    }

}
