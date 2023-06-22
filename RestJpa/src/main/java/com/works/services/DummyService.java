package com.works.services;

import com.works.models.Products;
import lombok.RequiredArgsConstructor;
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

}
