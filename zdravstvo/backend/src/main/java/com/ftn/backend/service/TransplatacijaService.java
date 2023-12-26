package com.ftn.backend.service;

import com.ftn.backend.dto.TransplatacijaDTO;
import com.ftn.backend.dto.VakcinaDTO;

import java.util.List;

public interface TransplatacijaService {
    void evidentirajZahtevZaTransplataciju(TransplatacijaDTO transplatacijaDTO) throws Exception;

    TransplatacijaDTO[] evidencijaTransplatacija(String jmbg);
}
