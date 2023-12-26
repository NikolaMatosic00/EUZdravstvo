package com.ftn.backend.controller;

import com.ftn.backend.dto.GenericResponseDTO;
import com.ftn.backend.model.Vakcinacija;
import com.ftn.backend.service.VakcinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/gradjanin")
public class GradjaninController {

    @Autowired
    private VakcinaService vakcinaService;

    /**
     * isotirjaVakcinisanja
     * @param jmbg
     * @return
     */
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    @GetMapping(value = "isotirjaVakcinisanja")
    public ResponseEntity<?> istorijaVakcinisannja(@RequestParam String jmbg){
        List<Vakcinacija> list =  vakcinaService.istorijaVakcinisanja(jmbg);
        return ResponseEntity.ok(list);
    }

    /**
     * proveraZaDavanjeKrvi
     * @param jmbg
     * @return
     */
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    @GetMapping(value = "proveraZaDavanjeKrvi")
    public ResponseEntity<?> proveraZaDavanjeKrvi(@RequestParam String jmbg) {
        return ResponseEntity.ok(new GenericResponseDTO(vakcinaService.proveraZaDavanjeKrvi(jmbg)));
    }
}
