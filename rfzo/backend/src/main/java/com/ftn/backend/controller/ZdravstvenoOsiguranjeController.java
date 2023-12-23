package com.ftn.backend.controller;

import com.ftn.backend.dto.UplataDTO;
import com.ftn.backend.service.UplataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/zdravstvenoOsiguranje")
public class ZdravstvenoOsiguranjeController {
    @Autowired
    private UplataService uplataService;
    @PreAuthorize("hasRole('ROLE_ADMINISTRATIVNI_RADNIK')")
    @PostMapping(value = "evidentirajUplatu")
    public ResponseEntity<?> evidentirajUplatu(@RequestBody UplataDTO request){
        uplataService.evidentirajUplatu(request);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRATIVNI_RADNIK')")
    @GetMapping(value = "istorijaUplata")
    public ResponseEntity<?> istorijaUplata(@RequestParam(required = false) String pibIliJMBG){
        return ResponseEntity.ok(uplataService.istorijaUplata(pibIliJMBG));
    }
}
