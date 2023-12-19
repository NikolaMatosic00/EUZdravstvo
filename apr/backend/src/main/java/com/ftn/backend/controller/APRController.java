package com.ftn.backend.controller;

import com.ftn.backend.dto.FirmaDTO;
import com.ftn.backend.dto.StringResponseDTO;
import com.ftn.backend.service.FirmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/apr")
public class APRController {

    @Autowired
    FirmaService firmaService;

    @GetMapping(value = "evidentirajFirmu")
    public ResponseEntity<?> evidentirajFirmu(@RequestParam String pib, @RequestParam String maticniBroj, @RequestParam String adresa, @RequestParam String naziv){
        firmaService.evidentirajFirmu(pib, maticniBroj, adresa, naziv);
        return ResponseEntity.ok(new StringResponseDTO("ok"));
    }

    @GetMapping(value = "evidencija")
    public ResponseEntity<?> evidencija(@RequestParam(required = false) String pib){
        FirmaDTO[] response = firmaService.evidencija(pib);
        return ResponseEntity.ok(response);
    }

}
