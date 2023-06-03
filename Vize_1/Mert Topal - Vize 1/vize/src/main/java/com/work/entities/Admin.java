package com.work.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;

    @Column(unique = true,length = 30)
    private String username;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String surname;

    @Column(unique = true, length = 150)
    private String email;

    @Column(length = 20)
    private String password;
}
