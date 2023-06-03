package com.work.entities;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
@Entity

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Column(length = 100)
    private String title;

    @Positive
    private Integer price;

    private String detail;

    @PositiveOrZero
    private Integer Stock;
    private Long aid;
}
