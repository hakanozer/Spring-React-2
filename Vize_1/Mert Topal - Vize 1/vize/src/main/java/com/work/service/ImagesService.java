package com.work.service;


import com.work.entities.ProductImage;
import com.work.repositories.ProductImageRepository;
import com.work.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImagesService {
    final ProductImageRepository imageRepository;
    final ProductRepository productRepository;
    final HttpServletResponse response;
    final HttpServletRequest request;


    public ProductImage addImage(ProductImage productImage){
        imageRepository.save(productImage);
        return productImage;
    }
    public List<ProductImage> list(Long pid){
        return imageRepository.findByPidEquals(pid);
    }

    @Transactional
    public boolean imageDelete(Long imgId){
        try {
            boolean status = imageRepository.existsByImgIdEquals(imgId);
            if(status){
                imageRepository.deleteByImgIdEquals(imgId);
                return true;
            }
        }catch (Exception ex){
            System.err.println(ex);
        }
        return false;
    }

}

