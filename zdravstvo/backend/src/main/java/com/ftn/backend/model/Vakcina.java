package com.ftn.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "vakcina")
public class Vakcina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "izdavac", nullable = true)
    private String izdavac;

    @Column(name = "naziv", nullable = true)
    private String naziv;

    @JsonIgnore
    @OneToMany(mappedBy="vakcina", fetch = FetchType.LAZY)
    private Set<Vakcinacija> vakcinacije;
}
