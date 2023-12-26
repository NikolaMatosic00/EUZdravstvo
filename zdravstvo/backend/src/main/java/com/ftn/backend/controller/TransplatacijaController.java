package com.ftn.backend.controller;

import com.ftn.backend.dto.TransplatacijaDTO;
import com.ftn.backend.dto.VakcinaDTO;
import com.ftn.backend.service.TransplatacijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/transplatacija")
public class TransplatacijaController {

    @Autowired
    TransplatacijaService transplatacijaService;

    /**
     * evidentirajZahtevZaTransplataciju
     * @param transplatacijaDTO
     * @return
     * @throws Exception
     */
    @PreAuthorize("hasRole('ROLE_ZDRAVSTVENI_RADNIK')")
    @PostMapping(value = "evidentirajZahtevZaTransplataciju")
    public ResponseEntity<?> evidentirajZahtevZaTransplataciju(@RequestBody TransplatacijaDTO transplatacijaDTO) throws Exception {
        transplatacijaService.evidentirajZahtevZaTransplataciju(transplatacijaDTO);
        return ResponseEntity.ok().build();
    }

    /**
     * evidencijaTransplatacija
     * @param jmbg
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ZDRAVSTVENI_RADNIK')")
    @GetMapping(value = "evidencijaTransplatacija")
    public ResponseEntity<?> evidencijaTransplatacija(@RequestParam(required = false) String jmbg){
        return ResponseEntity.ok(transplatacijaService.evidencijaTransplatacija(jmbg));
    }
}
