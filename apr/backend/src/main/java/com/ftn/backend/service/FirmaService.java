package com.ftn.backend.service;

import com.ftn.backend.dto.FirmaDTO;

public interface FirmaService {
    void evidentirajFirmu(String pib, String maticniBroj, String adresa, String naziv);

    FirmaDTO[] evidencija(String pib);
}
