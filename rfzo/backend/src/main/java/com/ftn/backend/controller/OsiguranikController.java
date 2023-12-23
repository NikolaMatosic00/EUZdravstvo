package com.ftn.backend.controller;

import com.ftn.backend.dto.BooleanResponseDTO;
import com.ftn.backend.model.Uplata;
import com.ftn.backend.service.UplataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/gradjanin")
public class OsiguranikController {

    @Autowired
    private UplataService uplataService;

    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    @GetMapping(value = "istoirjaUplata")
    public ResponseEntity<?> istoirjaUplata(@RequestParam String jmbg){
        List<Uplata> list =  uplataService.istorijaUplata(jmbg);
        return ResponseEntity.ok(list);
    }

    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    @GetMapping(value = "proveraDaLiJeZdravstvenoOsiguran")
    public ResponseEntity<?> proveraDaLiJeZdravstvenoOsiguran(@RequestParam String jmbg) throws ParseException {
        return ResponseEntity.ok(new BooleanResponseDTO(uplataService.proveraDaLiJeZdravstvenoOsiguran(jmbg)));
    }
}
