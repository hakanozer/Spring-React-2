package com.works.entites;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
public class Footballer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fid;

    @NotEmpty
    @NotNull
    private String name;

    @NotEmpty
    @NotNull
    private String surname;

    @Column(unique = true)
    @NotEmpty
    @NotNull
    @Email
    private String email;

    @NotEmpty
    @NotNull
    private String password;

    @Positive
    @Min(18)
    @NotNull
    private Integer age;

}
