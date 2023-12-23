package com.ftn.backend.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "uplata")
public class Uplata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vreme_uplate", nullable = false)
    private String vremeUplate;

    @Column(name = "ukupan_iznos_uplate", nullable = false)
    private Integer ukupanIznosUplate;

    @Column(name = "od_toga_zdravstveno_osiguranje", nullable = false)
    private Integer odTogaZdravstvenoOsiguranje;

    @Column(name = "ref_osiguranik", nullable = false)
    private Long refOsiguranik;

    @Column(name = "ref_osiguranik_jmbg", nullable = false)
    private String refOsiguranikJMBG;

    @Column(name = "ref_firma", nullable = false)
    private Long refFirma;

    @Column(name = "ref_firma_pib", nullable = false)
    private String refFirmaPIB;
}
