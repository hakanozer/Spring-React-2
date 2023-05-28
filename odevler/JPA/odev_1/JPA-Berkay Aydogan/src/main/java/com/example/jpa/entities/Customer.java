package com.example.jpa.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    @Column(length = 75)
    private String name;
    private String surname;

    @Column(unique = true, length = 150)
    private String email;

    @Column(length = 15)
    private String password;
    private Integer age;
    private Boolean status;
}
