package com.works.props;

import lombok.Data;

@Data
public class User {

    private int uid;
    private String name;
    private String surname;
    private Address address;

}
