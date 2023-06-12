package com.works.jpawork.repositories;

import com.works.jpawork.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Transactional
    @Modifying
    @Query("update Product p set p.title = ?1, p.price = ?2, p.stock = ?3, p.detail = ?4")
    void updateProduct(String title, Double price, Integer stock, String detail);
    Product findByTitleLikeIgnoreCaseOrDetailLikeIgnoreCase(String title, String detail);


}