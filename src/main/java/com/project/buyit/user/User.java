package com.project.buyit.user;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "users")
@EqualsAndHashCode(callSuper = false)
@Builder
public class User extends AuditBase {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String address;
    @NotBlank
    private String password;
    private boolean enabled;
}
