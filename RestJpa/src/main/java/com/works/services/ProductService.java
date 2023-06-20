package com.works.services;

import com.works.entities.Product;
import com.works.entities.projections.IProCat;
import com.works.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public ResponseEntity listCat(Long cid) {
        return new ResponseEntity(productRepository.proCatJoin(cid), HttpStatus.OK);
    }

    public ResponseEntity listCatPage(Long cid, int page) {
        Sort sort = Sort.by("price").descending();
        Pageable pageable = PageRequest.of(page, 3, sort);
        Page<IProCat> proCatPage = productRepository.proCatJoinPage(cid,pageable);
        return new ResponseEntity(proCatPage, HttpStatus.OK);
    }


}
