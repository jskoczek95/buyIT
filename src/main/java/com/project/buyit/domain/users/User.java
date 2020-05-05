package com.project.buyit.domain.users;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class User {

    UUID id;
    String firstName;
    String lastName;
    String email;
    String address;
    String password;
    boolean enabled;
}
