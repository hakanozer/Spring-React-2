package com.work.entities;


import lombok.Data;

import javax.persistence.*;
import java.sql.Blob;

@Data
@Entity
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imgId;

    private Long pid;

    @Lob
    private Blob image;

}
