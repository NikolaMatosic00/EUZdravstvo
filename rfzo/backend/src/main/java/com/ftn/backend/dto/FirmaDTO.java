package com.ftn.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FirmaDTO {
    private Long id;
    private String pib;
    private String naziv;
    private String adresa;
    private String maticniBroj;
}
