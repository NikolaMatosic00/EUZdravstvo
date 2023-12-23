package com.ftn.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class Controller {

    @PreAuthorize("hasAnyRole('ROLE_GRADJANIN', 'ROLE_ADMINISTRATIVNI_RADNIK')")
    @GetMapping("/test")
    public ResponseEntity<String> testAuth() {

        return ResponseEntity
                .ok()
                .body("SUCCESS!");
    }
}
