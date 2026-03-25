package com.bnpe.demo.controller;

import com.bnpe.demo.dto.ActionItemRequest;
import com.bnpe.demo.dto.ActionItemResponse;
import com.bnpe.demo.service.ActionItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actions")
@CrossOrigin(origins = "*")
public class ActionItemController {

    private final ActionItemService actionItemService;

    public ActionItemController(ActionItemService actionItemService) {
        this.actionItemService = actionItemService;
    }

    @PostMapping
    public ResponseEntity<ActionItemResponse> create(@Valid @RequestBody ActionItemRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(actionItemService.create(request));
    }

    @GetMapping("/dossier/{dossierId}")
    public ResponseEntity<List<ActionItemResponse>> findByDossier(@PathVariable Long dossierId) {
        return ResponseEntity.ok(actionItemService.findByDossier(dossierId));
    }
}
