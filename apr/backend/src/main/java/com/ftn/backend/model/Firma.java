package com.ftn.backend.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "firma")
public class Firma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pib;

    private String naziv;

    @Column(name = "maticni_broj")
    private String maticniBroj;

    private String adresa;
}
