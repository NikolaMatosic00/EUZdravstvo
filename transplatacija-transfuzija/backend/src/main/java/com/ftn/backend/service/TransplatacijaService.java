package com.ftn.backend.service;

import com.ftn.backend.dto.TransplatacijaDTO;

import java.util.List;

public interface TransplatacijaService {
    void evidentirajZahtev(String jmbg, String komentar);

    List<TransplatacijaDTO> evidencija(String jmbg);
}
