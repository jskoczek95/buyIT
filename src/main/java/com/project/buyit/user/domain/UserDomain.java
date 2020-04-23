package com.project.buyit.user.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDomain {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String password;
    private boolean enabled;
}
