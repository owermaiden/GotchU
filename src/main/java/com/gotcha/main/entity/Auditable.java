package com.gotcha.main.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<T> {

    @JsonIgnore
    @Column(name = "created_date", updatable = false)
    @Temporal(TemporalType.DATE)
    @CreatedDate
    protected Date creationDate;

    @JsonIgnore
    @Column(name = "lastMod_date")
    @LastModifiedDate
    @Temporal(TemporalType.DATE)
    protected Date lastModifiedDate;

    @JsonIgnore
    @CreatedBy
    @Column(name="created_by")
    protected T createdBy;

    @JsonIgnore
    @LastModifiedBy
    @Column(name="modified_by")
    protected T modifiedBy;
}
