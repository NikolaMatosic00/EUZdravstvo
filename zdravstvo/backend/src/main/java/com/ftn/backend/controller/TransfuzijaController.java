package com.ftn.backend.controller;

import com.ftn.backend.dto.GenericResponseDTO;
import com.ftn.backend.service.VakcinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/transfuzija")
public class TransfuzijaController {

    @Autowired
    private VakcinaService vakcinaService;

    /**
     * proveraZaDavanjeKrvi
     * @param jmbg
     * @return
     */
    @PreAuthorize("hasRole('ROLE_TRANSFUZIJA')")
    @GetMapping(value = "proveraZaDavanjeKrvi")
    public ResponseEntity<?> proveraZaDavanjeKrvi(@RequestParam(required = false) String jmbg) {
        return ResponseEntity.ok(new GenericResponseDTO(vakcinaService.proveraZaDavanjeKrvi(jmbg)));
    }
}
