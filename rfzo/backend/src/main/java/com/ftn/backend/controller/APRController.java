package com.ftn.backend.controller;

import com.ftn.backend.dto.FirmaDTO;
import com.ftn.backend.service.APRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/apr")
public class APRController {

    @Autowired
    private APRService aprService;

    @PreAuthorize("hasRole('ROLE_ADMINISTRATIVNI_RADNIK')")
    @GetMapping(value = "izlistajFirme")
    public ResponseEntity<?> izlistajFirme(@RequestParam(required = false) String pib) {
        return ResponseEntity.ok(aprService.izlistajFirme(pib));
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRATIVNI_RADNIK')")
    @PostMapping(value = "evidentirajFirmu")
    public ResponseEntity<?> evidentirajFirmu(@RequestBody FirmaDTO request) throws Exception {
        aprService.evidentirajFirmu(request);
        return ResponseEntity.ok().build();
    }
}
