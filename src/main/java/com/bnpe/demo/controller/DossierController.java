package com.bnpe.demo.controller;

import com.bnpe.demo.dto.DossierRequest;
import com.bnpe.demo.dto.DossierResponse;
import com.bnpe.demo.model.DossierStatus;
import com.bnpe.demo.service.DossierService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dossiers")
@CrossOrigin(origins = "*")
public class DossierController {

    private final DossierService dossierService;

    public DossierController(DossierService dossierService) {
        this.dossierService = dossierService;
    }

    @PostMapping
    public ResponseEntity<DossierResponse> create(@Valid @RequestBody DossierRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dossierService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<DossierResponse>> findAll() {
        return ResponseEntity.ok(dossierService.findAll());
    }

    @GetMapping("/agence/{agenceId}")
    public ResponseEntity<List<DossierResponse>> findByAgence(@PathVariable Long agenceId) {
        return ResponseEntity.ok(dossierService.findByAgence(agenceId));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<DossierResponse> updateStatus(
            @PathVariable Long id,
            @RequestParam DossierStatus statut,
            @RequestParam(required = false) String retourDg
    ) {
        return ResponseEntity.ok(dossierService.updateStatus(id, statut, retourDg));
    }

    @GetMapping("/statuts")
    public ResponseEntity<Map<String, Object>> statutsDisponibles() {
        Map<String, Object> response = new HashMap<>();
        response.put("statuts", DossierStatus.values());
        return ResponseEntity.ok(response);
    }
}
