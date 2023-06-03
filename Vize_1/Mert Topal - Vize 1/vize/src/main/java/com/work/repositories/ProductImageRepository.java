package com.work.repositories;

import com.work.entities.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    List<ProductImage> findByPidEquals(Long pid);

    long deleteByImgIdEquals(Long imgId);
    boolean existsByImgIdEquals(Long imgId);
}