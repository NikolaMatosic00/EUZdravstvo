package com.ftn.backend.controller;

import com.ftn.backend.dto.StringResponseDTO;
import com.ftn.backend.dto.ZaposleniDTO;
import com.ftn.backend.service.CROSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/croso")
public class CROSOController {

    @Autowired
    CROSOService crosoService;

    @GetMapping(value = "evidentirajZaposlenog")
    public ResponseEntity<?> evidentirajZaposlenog(@RequestParam String refPib, @RequestParam String jmbg, @RequestParam String ime, @RequestParam String prezime){
        crosoService.evidentirajZaposlenog(refPib, jmbg, ime, prezime);
        return ResponseEntity.ok(new StringResponseDTO("ok"));
    }

    @GetMapping(value = "evidencija")
    public ResponseEntity<?> evidencija(@RequestParam(required = false) String pibIliJMBG){
        ZaposleniDTO[] response = crosoService.evidencija(pibIliJMBG);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "findById")
    public ResponseEntity<?> findById(@RequestParam(required = false) Long id){
        ZaposleniDTO response = crosoService.findById(id);
        return ResponseEntity.ok(response);
    }
}
