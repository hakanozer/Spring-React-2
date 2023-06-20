package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductRestController {

    final ProductService productService;

    @PostMapping("/save")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/list")
    public ResponseEntity products() {
        return productService.list();
    }

    @GetMapping("/list/{cid}")
    public ResponseEntity products(@PathVariable Long cid) {
        return productService.listCat(cid);
    }

    @GetMapping("/listPage/{cid}")
    public ResponseEntity products(@PathVariable Long cid, @RequestParam(defaultValue = "0") int page) {
        return productService.listCatPage(cid,page);
    }


}
