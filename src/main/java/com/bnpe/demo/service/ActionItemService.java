package com.bnpe.demo.service;

import com.bnpe.demo.dto.ActionItemRequest;
import com.bnpe.demo.dto.ActionItemResponse;
import com.bnpe.demo.exception.ResourceNotFoundException;
import com.bnpe.demo.model.ActionItem;
import com.bnpe.demo.model.Dossier;
import com.bnpe.demo.repository.ActionItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ActionItemService {

    private final ActionItemRepository actionItemRepository;
    private final DossierService dossierService;

    public ActionItemService(ActionItemRepository actionItemRepository, DossierService dossierService) {
        this.actionItemRepository = actionItemRepository;
        this.dossierService = dossierService;
    }

    public ActionItemResponse create(ActionItemRequest request) {
        Dossier dossier = dossierService.findEntityById(request.getDossierId());

        ActionItem item = new ActionItem();
        item.setLibelle(request.getLibelle());
        item.setResponsable(request.getResponsable());
        item.setStatut(request.getStatut());
        item.setDateEcheance(request.getDateEcheance());
        item.setDossier(dossier);

        return mapToResponse(actionItemRepository.save(item));
    }

    @Transactional(readOnly = true)
    public List<ActionItemResponse> findByDossier(Long dossierId) {
        dossierService.findEntityById(dossierId);
        List<ActionItem> items = actionItemRepository.findByDossierIdOrderByCreatedAtDesc(dossierId);
        List<ActionItemResponse> responses = new ArrayList<>();
        for (ActionItem item : items) {
            responses.add(mapToResponse(item));
        }
        return responses;
    }

    @Transactional(readOnly = true)
    public ActionItem findEntityById(Long id) {
        return actionItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Action introuvable : " + id));
    }

    private ActionItemResponse mapToResponse(ActionItem item) {
        ActionItemResponse response = new ActionItemResponse();
        response.setId(item.getId());
        response.setLibelle(item.getLibelle());
        response.setResponsable(item.getResponsable());
        response.setStatut(item.getStatut());
        response.setDateEcheance(item.getDateEcheance());
        response.setDossierId(item.getDossier().getId());
        response.setDossierReference(item.getDossier().getReference());
        response.setCreatedAt(item.getCreatedAt());
        return response;
    }
}