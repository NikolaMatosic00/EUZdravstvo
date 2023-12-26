package com.ftn.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VakcinacijaReqDTO {
    private Long idOsiguranik;
    private Long idVakcina;

}
