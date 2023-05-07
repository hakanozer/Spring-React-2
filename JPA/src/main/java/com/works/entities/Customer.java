package com.works.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    @Column(length = 100)
    private String name;

    @Column(unique = true, length = 150)
    private String email;

    @Column(length = 15)
    private String password;

    private Integer age;

    private Boolean status;

}
