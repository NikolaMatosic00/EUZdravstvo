package com.ftn.backend.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "zaposleni")
public class Zaposleni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ref_pib")
    private String refPib;

    private String jmbg;

    private String ime;

    private String prezime;
}

