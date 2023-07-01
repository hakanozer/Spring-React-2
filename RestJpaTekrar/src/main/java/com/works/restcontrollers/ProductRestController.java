package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductRestController {
    final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody Product product) {
        String s1 = "a10";
        int ca1 = Integer.parseInt(s1);
        return productService.save(product);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return productService.list();
    }

}