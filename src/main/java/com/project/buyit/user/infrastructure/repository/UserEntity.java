package com.project.buyit.user.infrastructure.repository;

import com.project.buyit.bidding.infrastructure.repository.BidEntity;
import com.project.buyit.bidding.infrastructure.repository.OfferEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends AuditBase {

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
    @OneToOne(mappedBy = "user")
    private OfferEntity offer;
    @OneToMany(mappedBy = "user")
    private List<BidEntity> bids = new ArrayList<>();
}
