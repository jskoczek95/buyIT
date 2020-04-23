package com.project.buyit.commons;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
public class AggregateId implements Serializable {

    private UUID aggregateId;

    public AggregateId() {
    }

    public AggregateId(UUID aggregateId) {
        this.aggregateId = aggregateId;
    }

    public static AggregateId generate() {
        return new AggregateId(UUID.randomUUID());
    }
}
