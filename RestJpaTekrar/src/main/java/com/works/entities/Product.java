package com.works.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    private String title;
    private Integer price;

    @OneToOne
    private Category category;

}
