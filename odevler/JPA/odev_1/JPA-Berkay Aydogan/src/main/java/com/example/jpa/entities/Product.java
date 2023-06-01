package com.example.jpa.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pid;

    @Column(length = 100)
    private String title;

    @Positive
    private Integer price;

    private String detail;

    @PositiveOrZero
    private Integer Stock;
}
