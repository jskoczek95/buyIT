package com.project.buyit.commons;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.Objects;

@MappedSuperclass
public abstract class BaseAggregateRoot {

    @EmbeddedId
    protected AggregateId aggregateId;

    @Version
    private Long version;

    public AggregateId getAggregateId() {
        return aggregateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseAggregateRoot that = (BaseAggregateRoot) o;
        return Objects.equals(aggregateId, that.aggregateId) &&
                Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aggregateId, version);
    }
}
