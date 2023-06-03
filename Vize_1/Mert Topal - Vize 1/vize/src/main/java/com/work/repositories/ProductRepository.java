package com.work.repositories;

import com.work.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitleLikeIgnoreCase( String title);


    Product findByPidEquals(Long pid);
    boolean existsByPidEqualsAndAidEquals(Long pid, Long aid);
    Page<Product> findByAidEquals(Long aid, Pageable pageable);
}