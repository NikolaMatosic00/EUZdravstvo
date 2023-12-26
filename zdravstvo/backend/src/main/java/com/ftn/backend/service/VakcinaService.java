package com.ftn.backend.service;

import com.ftn.backend.dto.OsiguranikDTO;
import com.ftn.backend.dto.VakcinaDTO;
import com.ftn.backend.dto.VakcinacijaReqDTO;
import com.ftn.backend.model.Osiguranik;
import com.ftn.backend.model.Vakcina;
import com.ftn.backend.model.Vakcinacija;

import java.util.List;

public interface VakcinaService {

    List<Vakcinacija> istorijaVakcinisanja(String jmbg);

    boolean proveraZaDavanjeKrvi(String jmbg);

    List<Osiguranik> listaOsiguranika();

    List<Vakcina> listaVakcina();

    void registrujVakcinaciju(VakcinacijaReqDTO vakcinacijaReqDTO);

    void registrujVakcinu(VakcinaDTO vakcinaDTO);

    void registrujOsiguranika(OsiguranikDTO osiguranikDTO) throws Exception;


}
