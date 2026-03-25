package com.bnpe.demo.controller;

import com.bnpe.demo.dto.AgenceRequest;
import com.bnpe.demo.dto.AgenceResponse;
import com.bnpe.demo.service.AgenceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
@CrossOrigin(origins = "*")
public class AgenceController {

    private final AgenceService agenceService;

    public AgenceController(AgenceService agenceService) {
        this.agenceService = agenceService;
    }

    @PostMapping
    public ResponseEntity<AgenceResponse> create(@Valid @RequestBody AgenceRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(agenceService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<AgenceResponse>> findAll() {
        return ResponseEntity.ok(agenceService.findAll());
    }
}
