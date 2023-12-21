package com.ftn.backend.service.implementation;

import com.ftn.backend.dto.ZaposleniDTO;
import com.ftn.backend.model.Zaposleni;
import com.ftn.backend.repository.ZaposleniRepository;
import com.ftn.backend.service.CROSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CROSOServiceImpl implements CROSOService {

    @Autowired
    ZaposleniRepository zaposleniRepository;

    @Override
    public void evidentirajZaposlenog(String refPib, String jmbg, String ime, String prezime) {
        Zaposleni z = new Zaposleni();
        z.setJmbg(jmbg);
        z.setIme(ime);
        z.setPrezime(prezime);
        z.setRefPib(refPib);
        zaposleniRepository.save(z);
    }

    @Override
    public ZaposleniDTO[] evidencija(String pibIliJMBG) {
        if (pibIliJMBG == null || pibIliJMBG.isBlank() || pibIliJMBG.equals("null")) {
            return zaposleniRepository.findAll().stream().map(z -> new ZaposleniDTO(z.getId(), z.getIme(), z.getPrezime(), z.getJmbg(), z.getRefPib())).collect(Collectors.toList()).toArray(ZaposleniDTO[]::new);
        }
        return zaposleniRepository.findAllByJmbgOrRefPib(pibIliJMBG, pibIliJMBG).stream().map(z -> new ZaposleniDTO(z.getId(), z.getIme(), z.getPrezime(), z.getJmbg(), z.getRefPib())).collect(Collectors.toList()).toArray(ZaposleniDTO[]::new);
    }

    @Override
    public ZaposleniDTO findById(Long id) {
        Zaposleni z = zaposleniRepository.getById(id);
        return new ZaposleniDTO(z.getId(), z.getIme(), z.getPrezime(), z.getJmbg(), z.getRefPib());
    }
}
