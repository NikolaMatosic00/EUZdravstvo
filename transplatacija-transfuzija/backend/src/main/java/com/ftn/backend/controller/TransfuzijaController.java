package com.ftn.backend.controller;

import com.ftn.backend.dto.TransplatacijaGenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/transfuzija")
public class TransfuzijaController {


    @GetMapping(value = "validacija")
    public ResponseEntity<?> validacija(@RequestParam long brojFajzera){
        if(brojFajzera>=3){
            return ResponseEntity.ok(new TransplatacijaGenericResponseDTO("nok"));
        }
        return ResponseEntity.ok(new TransplatacijaGenericResponseDTO("ok"));
    }

}
