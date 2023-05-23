package com.works.services;

import com.works.entities.ProductImage;
import com.works.repositories.ProductImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {

    final ProductImageRepository imageRepository;

    public ProductImage addImage( ProductImage productImage ) {
        imageRepository.save(productImage);
        return productImage;
    }

    public List<ProductImage> list(Long pid) {
        return imageRepository.findByPidEquals(pid);
    }

}
