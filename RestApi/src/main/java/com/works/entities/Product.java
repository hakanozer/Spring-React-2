package com.works.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Size(min = 2, max = 150)
    @NotEmpty
    @NotNull
    @Column(unique = true)
    private String title;

    @Size(min = 5, max = 500)
    @NotEmpty
    @NotNull
    private String detail;

    @Max(99000000)
    @Min(2)
    @NotNull
    private Integer price;

    @NotNull
    private Boolean status;

}
