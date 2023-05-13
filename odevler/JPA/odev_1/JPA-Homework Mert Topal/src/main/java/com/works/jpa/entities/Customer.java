package com.works.jpa.entities;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;

import javax.validation.constraints.Positive;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String surname;

    @Column(unique = true, length = 150)
    private String email;

    @Column(length = 20)
    private String password;

    @Positive
    private Integer age;

    private Boolean status;



}