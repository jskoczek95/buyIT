package com.project.buyit.offer.infrastructure.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "offers")
public class OfferEntity {

    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String description;
    private BigDecimal price;

    public OfferEntity(String title, String description, BigDecimal price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }
}
