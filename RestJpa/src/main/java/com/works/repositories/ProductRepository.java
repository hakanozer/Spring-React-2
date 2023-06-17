package com.works.repositories;

import com.works.entities.Product;
import com.works.entities.projections.IProCat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select P.PID, P.TITLE, P.PRICE, C.CID, C.NAME from PUBLIC.PRODUCT as P\n" +
            "    inner join PUBLIC.PRODUCT_CATEGORIES PC on P.PID = PC.PRODUCT_PID\n" +
            "    inner join PUBLIC.CATEGORY as C on C.CID = PC.CATEGORIES_CID", nativeQuery = true)
    List<IProCat> proCatJoin();



}