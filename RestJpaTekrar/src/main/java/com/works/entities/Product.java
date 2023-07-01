package com.works.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    @Size(min = 2, max = 100)
    @NotEmpty
    @NotNull
    private String title;

    @Max(1000000)
    @Min(2)
    @NotNull
    private Integer price;

    @NotNull
    @OneToOne
    @JoinColumn
    private Category category;

}
