package com.project.buyit.user.domain;

import com.project.buyit.bidding.domain.offers.Offer;
import lombok.Data;

import java.util.List;
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
    private List<Offer> offers;
}
