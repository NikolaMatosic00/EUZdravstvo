package com.ftn.backend.service.implementation;

import com.ftn.backend.dto.TransplatacijaGenericResponseDTO;
import com.ftn.backend.dto.TransplatacijaDTO;
import com.ftn.backend.service.TransplatacijaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TransplatacijaServiceImpl implements TransplatacijaService {
    @Override
    public void evidentirajZahtevZaTransplataciju(TransplatacijaDTO transplatacijaDTO) throws Exception {
        RestTemplate template = new RestTemplate();
        ResponseEntity<TransplatacijaGenericResponseDTO> response = template.getForEntity("http://transplatacija-transfuzija-backend:8002/api/transplatacija/evidentiraj-zahtev?jmbg=" + transplatacijaDTO.getJmbg() + "&komentar=" + transplatacijaDTO.getKomentar() , TransplatacijaGenericResponseDTO.class);

        if (!(response.getStatusCode().is2xxSuccessful() && response.getBody() != null)) {
            throw new Exception("Invalid data");
        }
    }

    @Override
    public TransplatacijaDTO[] evidencijaTransplatacija(String jmbg) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<TransplatacijaDTO[]> response = template.getForEntity("http://transplatacija-transfuzija-backend:8002/api/transplatacija/evidencija?jmbg=" + jmbg , TransplatacijaDTO[].class);
        System.out.println(Arrays.deepToString(response.getBody()));
        return response.getBody();
    }
}
