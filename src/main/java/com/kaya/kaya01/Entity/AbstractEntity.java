package com.kaya.kaya01.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
@Data
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "creationDate", nullable = false)
    private Instant creationDate;

    @Column(name = "lastMofiedDate")
    private Instant lastMofiedDate;

    @PrePersist
    public void prePersist() {
        creationDate = Instant.now();
    }
    @PreUpdate
    void predate(){
        lastMofiedDate = Instant.now();
    }

}
