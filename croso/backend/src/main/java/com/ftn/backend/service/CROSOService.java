package com.ftn.backend.service;

import com.ftn.backend.dto.ZaposleniDTO;

public interface CROSOService {
    void evidentirajZaposlenog(String refPib, String jmbg, String ime, String prezime);

    ZaposleniDTO[] evidencija(String pibIliJMBG);

    ZaposleniDTO findById(Long id);
}
