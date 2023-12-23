package com.ftn.backend.service.implementation;

import com.ftn.backend.dto.FirmaDTO;
import com.ftn.backend.dto.StringResponseDTO;
import com.ftn.backend.service.APRService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class APRServiceImpl implements APRService {
    @Override
    public FirmaDTO[] izlistajFirme(String pib) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<FirmaDTO[]> response = template.getForEntity("http://apr-backend:11002/api/apr/evidencija?pib=" + pib , FirmaDTO[].class);
        System.out.println(Arrays.deepToString(response.getBody()));
        return response.getBody();
    }

    @Override
    public void evidentirajFirmu(FirmaDTO request) throws Exception {
        RestTemplate template = new RestTemplate();
        ResponseEntity<StringResponseDTO> response = template.getForEntity("http://apr-backend:11002/api/apr/evidentirajFirmu?pib=" + request.getPib() + "&maticniBroj=" + request.getMaticniBroj() + "&adresa=" + request.getAdresa() + "&naziv=" + request.getNaziv(), StringResponseDTO.class);

        if (!(response.getStatusCode().is2xxSuccessful() && response.getBody() != null)) {
            throw new Exception("Invalid data");
        }
    }


}
