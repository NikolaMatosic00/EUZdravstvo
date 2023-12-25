package com.ftn.backend.controller;

import com.ftn.backend.dto.TransplatacijaDTO;
import com.ftn.backend.dto.TransplatacijaGenericResponseDTO;
import com.ftn.backend.service.TransplatacijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("api/transplatacija")
public class TransplatacijaController {

    @Autowired
    TransplatacijaService transplatacijaService;
    
    @GetMapping(value = "evidentiraj-zahtev")
    public ResponseEntity<?> evidentirajZahtev(@RequestParam String jmbg, @RequestParam String komentar){
        transplatacijaService.evidentirajZahtev(jmbg, komentar);
        return ResponseEntity.ok(new TransplatacijaGenericResponseDTO("ok"));
    }

    @GetMapping(value = "evidencija")
    public ResponseEntity<?> evidencija(@RequestParam(required = false) String jmbg){
        List<TransplatacijaDTO> list = transplatacijaService.evidencija(jmbg);
        System.out.println("evidencijaaa");
        System.out.println(list);
        TransplatacijaDTO[] arrRes = new TransplatacijaDTO[list.size()];
        for(int i=0; i<list.size(); i++){
            arrRes[i] = list.get(i);
        }
        return ResponseEntity.ok(arrRes);
    }

}
