package com.ftn.backend.service.implementation;

import com.ftn.backend.dto.FirmaDTO;
import com.ftn.backend.model.Firma;
import com.ftn.backend.repository.FirmaRepository;
import com.ftn.backend.service.FirmaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
public class FirmaServiceImpl implements FirmaService {
    @Autowired
    FirmaRepository firmaRepository;


    @Override
    public void evidentirajFirmu(String pib, String maticniBroj, String adresa, String naziv) {
        Firma f = new Firma();
        f.setPib(pib);
        f.setMaticniBroj(maticniBroj);
        f.setAdresa(adresa);
        f.setNaziv(naziv);
        firmaRepository.save(f);
    }

    @Override
    public FirmaDTO[] evidencija(String pib) {
        if (pib == null || pib.isBlank() || pib.equals("null")) {
            return firmaRepository.findAll().stream().map(f -> new FirmaDTO(f.getId(), f.getPib(), f.getNaziv(), f.getAdresa(), f.getMaticniBroj())).collect(Collectors.toList()).toArray(FirmaDTO[]::new);
        }

        return firmaRepository.findAllByPib(pib).stream().map(f -> new FirmaDTO(f.getId(), f.getPib(), f.getNaziv(), f.getAdresa(), f.getMaticniBroj())).collect(Collectors.toList()).toArray(FirmaDTO[]::new);

    }
}
