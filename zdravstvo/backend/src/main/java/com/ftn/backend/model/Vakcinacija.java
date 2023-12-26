package com.ftn.backend.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "vakcinacija")
public class Vakcinacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "broj_doze", nullable = false)
    private Integer brojDoze;

    @Column(name = "vreme_vakcinisanja", nullable = false)
    private Date vremeVakcinisanja;

    @Column(name = "preporuceno_vreme_za_sledecu_dozu", nullable = false)
    private Date preporucenoVremeZaSledecuDozu;

    @ManyToOne
    private Osiguranik osiguranik;

    @ManyToOne
    private Vakcina vakcina;
}
