package com.ftn.backend.service.implementation;

import com.ftn.backend.dto.TransplatacijaGenericResponseDTO;
import com.ftn.backend.dto.OsiguranikDTO;
import com.ftn.backend.dto.VakcinaDTO;
import com.ftn.backend.dto.VakcinacijaReqDTO;
import com.ftn.backend.model.Osiguranik;
import com.ftn.backend.model.Vakcina;
import com.ftn.backend.model.Vakcinacija;
import com.ftn.backend.repository.OsiguranikRepository;
import com.ftn.backend.repository.VakcinaRepository;
import com.ftn.backend.repository.VakcinacijaRepository;
import com.ftn.backend.service.VakcinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class VakcinaServiceImpl implements VakcinaService {

    private static final String IZDAVAC_FAJZER = "FAJZER";

    @Autowired
    OsiguranikRepository osiguranikRepository;

    @Autowired
    VakcinaRepository vakcinaRepository;

    @Autowired
    VakcinacijaRepository vakcinacijaRepository;

    @Override
    public List<Vakcinacija> istorijaVakcinisanja(String jmbg) {
        if (jmbg == null) {
            return vakcinacijaRepository.findAllOrderByVremeVakcinisanjaDesc();
        }
        return vakcinacijaRepository.findAllByOsiguranikJmbgOrderByVremeVakcinisanjaDesc(jmbg);
    }

    @Override
    public boolean proveraZaDavanjeKrvi(String jmbg) {
        Osiguranik o = osiguranikRepository.findByJmbg(jmbg);
        if (o == null) {
            return true;
        }
        long brojFajzera = o.getVakcinacije().stream().filter(v -> v.getVakcina().getIzdavac().equalsIgnoreCase(IZDAVAC_FAJZER)).count();

        RestTemplate template = new RestTemplate();
        ResponseEntity<TransplatacijaGenericResponseDTO> response = template.getForEntity("http://transplatacija-transfuzija-backend:8002/api/transfuzija/validacija?brojFajzera=" + brojFajzera , TransplatacijaGenericResponseDTO.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            String msg = response.getBody().getResponse();
            return msg.equals("ok");
        }
        return false;
    }

    @Override
    public List<Osiguranik> listaOsiguranika() {
        return osiguranikRepository.findAll();
    }

    @Override
    public List<Vakcina> listaVakcina() {
        return vakcinaRepository.findAll();
    }

    @Override
    public void registrujVakcinaciju(VakcinacijaReqDTO vakcinacijaReqDTO) {
        Vakcinacija v = new Vakcinacija();
        v.setVakcina(vakcinaRepository.getById(vakcinacijaReqDTO.getIdVakcina()));
        Osiguranik o = osiguranikRepository.getById(vakcinacijaReqDTO.getIdOsiguranik());
        v.setBrojDoze(o.getVakcinacije().size() + 1);
        v.setVremeVakcinisanja(new Date());
        v.setOsiguranik(o);
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, 1);
        v.setPreporucenoVremeZaSledecuDozu(c.getTime());
        vakcinacijaRepository.save(v);
    }

    @Override
    public void registrujVakcinu(VakcinaDTO vakcinaDTO) {
        Vakcina v = new Vakcina();
        v.setIzdavac(vakcinaDTO.getIzdavac());
        v.setNaziv(vakcinaDTO.getNaziv());
        vakcinaRepository.save(v);
    }

    @Override
    public void registrujOsiguranika(OsiguranikDTO osiguranikDTO) throws Exception {
        Osiguranik o = new Osiguranik();
        o.setIme(osiguranikDTO.getIme());
        o.setJmbg(osiguranikDTO.getJmbg());
        o.setPrezime(osiguranikDTO.getPrezime());
        o.setDatumRodjenja(osiguranikDTO.getDatumRodjenja());
        osiguranikRepository.save(o);
    }
}
