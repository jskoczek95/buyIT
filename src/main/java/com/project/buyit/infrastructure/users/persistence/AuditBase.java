package com.project.buyit.infrastructure.users.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class AuditBase {

    @Id
    @GeneratedValue
    private UUID id;

    @CreatedDate
    @NotNull
    @Column(name = "created_on")
    private LocalDateTime createdOn = LocalDateTime.now();

    @LastModifiedDate
    @NotNull
    @Column(name = "modified_on")
    private LocalDateTime modifiedOn = LocalDateTime.now();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuditBase)) return false;
        AuditBase auditBase = (AuditBase) o;
        return Objects.equals(id, auditBase.id) &&
                Objects.equals(createdOn, auditBase.createdOn) &&
                Objects.equals(modifiedOn, auditBase.modifiedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdOn, modifiedOn);
    }
}
