package com.ftn.backend.controller;

import com.ftn.backend.dto.ZaposleniDTO;
import com.ftn.backend.service.CROSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/croso")
public class CROSOController {

    @Autowired
    CROSOService crosoService;

    @PreAuthorize("hasRole('ROLE_ADMINISTRATIVNI_RADNIK')")
    @GetMapping(value = "izlistajOsiguranike")
    public ResponseEntity<?> izlistajOsiguranike(@RequestParam(required = false) String pibIliJMBG) {
        return ResponseEntity.ok(crosoService.izlistajOsiguranike(pibIliJMBG));
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRATIVNI_RADNIK')")
    @PostMapping(value = "evidentirajZaposlenog")
    public ResponseEntity<?> evidentirajZaposlenog(@RequestBody ZaposleniDTO request) throws Exception {
        crosoService.evidentirajZaposlenog(request);
        return ResponseEntity.ok().build();
    }
}
