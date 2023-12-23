package com.ftn.backend.service.implementation;

import com.ftn.backend.dto.FirmaDTO;
import com.ftn.backend.dto.StringResponseDTO;
import com.ftn.backend.dto.ZaposleniDTO;
import com.ftn.backend.service.CROSOService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class CROSOServiceImpl implements CROSOService {
    @Override
    public ZaposleniDTO[] izlistajOsiguranike(String pibIliJMBG) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<ZaposleniDTO[]> response = template.getForEntity("http://croso-backend:12002/api/croso/evidencija?pibIliJMBG=" + pibIliJMBG , ZaposleniDTO[].class);
        return response.getBody();
    }

    @Override
    public void evidentirajZaposlenog(ZaposleniDTO request) throws Exception {
        RestTemplate template = new RestTemplate();
        ResponseEntity<StringResponseDTO> response = template.getForEntity("http://croso-backend:12002/api/croso/evidentirajZaposlenog?refPib=" + request.getRefPib() + "&jmbg=" + request.getJmbg() + "&ime=" + request.getIme() + "&prezime=" + request.getPrezime(), StringResponseDTO.class);

        if (!(response.getStatusCode().is2xxSuccessful() && response.getBody() != null)) {
            throw new Exception("Invalid data");
        }

    }

    @Override
    public ZaposleniDTO findById(Long id) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<ZaposleniDTO> response = template.getForEntity("http://croso-backend:12002/api/croso/findById?id=" + id , ZaposleniDTO.class);
        return response.getBody();
    }
}
