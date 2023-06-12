package com.works.jpawork.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    private String name;
    private String surname;

    @Column(unique = true)
    private String email;

    private String password;
    private String country;
    private String city;

    @Column(length = 500)
    private String adress;

    private Boolean status;
    private String remember;
}
