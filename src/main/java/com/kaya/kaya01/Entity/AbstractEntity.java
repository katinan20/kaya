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
    private Long id;

    @Column(name = "createdAt", nullable = false)
    private Instant createdAt;

    @Column(name = "updateAt")
    private Instant updateAt;

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }
    @PreUpdate
    void predate(){
        createdAt = Instant.now();
    }

}
