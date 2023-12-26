package com.ftn.backend.controller;

import com.ftn.backend.dto.OsiguranikDTO;
import com.ftn.backend.dto.VakcinaDTO;
import com.ftn.backend.dto.VakcinacijaReqDTO;
import com.ftn.backend.service.VakcinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/zdravstveni-radnik")
public class ZdravstveniRadnikController {

    @Autowired
    private VakcinaService vakcinaService;

    /**
     * registrujVakcinaciju
     * @param vakcinacijaReqDTO
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ZDRAVSTVENI_RADNIK')")
    @PostMapping(value = "registrujVakcinaciju")
    public ResponseEntity<?> registrujVakcinaciju(@RequestBody VakcinacijaReqDTO vakcinacijaReqDTO){
        vakcinaService.registrujVakcinaciju(vakcinacijaReqDTO);
        return ResponseEntity.ok().build();
    }

    /**
     * registrujVakcinu
     * @param vakcinaDTO
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ZDRAVSTVENI_RADNIK')")
    @PostMapping(value = "registrujVakcinu")
    public ResponseEntity<?> registrujVakcinu(@RequestBody VakcinaDTO vakcinaDTO){
        vakcinaService.registrujVakcinu(vakcinaDTO);
        return ResponseEntity.ok().build();
    }

    /**
     * registrujOsiguranika
     * @param osiguranikDTO
     * @return
     * @throws Exception
     */
    @PreAuthorize("hasRole('ROLE_ZDRAVSTVENI_RADNIK')")
    @PostMapping(value = "registrujOsiguranika")
    public ResponseEntity<?> registrujOsiguranika(@RequestBody OsiguranikDTO osiguranikDTO) throws Exception {
        vakcinaService.registrujOsiguranika(osiguranikDTO);
        return ResponseEntity.ok().build();
    }

    /**
     * istorijaVakcinisanja
     * @param jmbg
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ZDRAVSTVENI_RADNIK')")
    @GetMapping(value = "istorijaVakcinisanja")
    public ResponseEntity<?> istorijaVakcinisanja(@RequestParam(required = false) String jmbg){
        return ResponseEntity.ok(vakcinaService.istorijaVakcinisanja(jmbg));
    }

    /**
     * listaOsiguranika
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ZDRAVSTVENI_RADNIK')")
    @GetMapping(value = "listaOsiguranika")
    public ResponseEntity<?> listaOsiguranika(){
        return ResponseEntity.ok(vakcinaService.listaOsiguranika());
    }

    /**
     * listaVakcina
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ZDRAVSTVENI_RADNIK')")
    @GetMapping(value = "listaVakcina")
    public ResponseEntity<?> listaVakcina(){
        return ResponseEntity.ok(vakcinaService.listaVakcina());
    }
}
