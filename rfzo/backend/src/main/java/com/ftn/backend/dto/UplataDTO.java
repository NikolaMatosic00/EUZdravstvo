package com.ftn.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UplataDTO {
    private long idFirma;
    private long idZaposleni;
    private int iznos;
    private String vremeUplate;
}
