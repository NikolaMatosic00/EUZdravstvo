package com.ftn.backend.service.implementation;

import com.ftn.backend.dto.TransplatacijaDTO;
import com.ftn.backend.model.Transplatacija;
import com.ftn.backend.repository.TransplatacijaRepository;
import com.ftn.backend.service.TransplatacijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransplatacijaServiceImpl implements TransplatacijaService {

    @Autowired
    TransplatacijaRepository transplatacijaRepository;
    @Override
    public void evidentirajZahtev(String jmbg, String komentar) {
        Transplatacija t = new Transplatacija();
        t.setJmbg(jmbg);
        t.setKomentar(komentar);
        transplatacijaRepository.saveAndFlush(t);
        System.out.println("stored -> id is " + t.getId());
    }

    @Override
    public List<TransplatacijaDTO> evidencija(String jmbg) {

        List<TransplatacijaDTO> response = new ArrayList<>();
        List<Transplatacija> res = new ArrayList<>();
        if (jmbg == null || jmbg.isBlank() || jmbg.equals("null")) {
            res = transplatacijaRepository.findAll();
        }else{
            res = transplatacijaRepository.findAllByJmbg(jmbg);
        }
        System.out.println(res);
        for(Transplatacija t:res){
            TransplatacijaDTO tr = new TransplatacijaDTO(t.getId(), t.getJmbg(), t.getKomentar());
            response.add(tr);
        }
        return response;
    }
}
