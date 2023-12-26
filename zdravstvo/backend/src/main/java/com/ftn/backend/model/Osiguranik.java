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
@Table(name = "osiguranik")
public class Osiguranik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ime", nullable = true)
    private String ime;

    @Column(name = "prezime", nullable = true)
    private String prezime;

    @Column(name = "jmbg", nullable = false)
    private String jmbg;

    @Column(name = "datum_rodjenja", nullable = false)
    private String datumRodjenja;

    @JsonIgnore
    @OneToMany(mappedBy="osiguranik", fetch = FetchType.LAZY)
    private Set<Vakcinacija> vakcinacije;
}
