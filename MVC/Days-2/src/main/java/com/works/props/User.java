package com.works.props;

import lombok.Data;

@Data
public class User {

    private int uid;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Integer age;
    private String date;
    private String remember;
}
