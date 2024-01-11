package com.kaya.kaya01.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
@Data
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @CreatedDate
    @Column(name = "creationDate", nullable = false)
   // @JsonIgnore
    private Instant creationDate;

    @LastModifiedDate
    @Column(name = "lastMofiedDate")
    //@JsonIgnore
    private Instant lastMofiedDate;
}
