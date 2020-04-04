package com.project.buyit.user.domain;

import lombok.Data;

@Data
public class UserDomain {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String password;
    private boolean enabled;
}
