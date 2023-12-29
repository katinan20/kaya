package com.kaya.kaya01.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@Table(name = "photos")
public class Photos  extends AbstractEntity{

    @Column(name = "urlPhtoo")
    private String url;

    @ManyToOne
    @JoinColumn(name = "idproperty")
    private Property property;

}
