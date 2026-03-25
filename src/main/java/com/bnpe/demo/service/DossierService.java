package com.bnpe.demo.service;

import com.bnpe.demo.dto.DossierRequest;
import com.bnpe.demo.dto.DossierResponse;
import com.bnpe.demo.exception.ResourceNotFoundException;
import com.bnpe.demo.model.Agence;
import com.bnpe.demo.model.Dossier;
import com.bnpe.demo.model.DossierStatus;
import com.bnpe.demo.model.User;
import com.bnpe.demo.repository.DossierRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DossierService {

    private final DossierRepository dossierRepository;
    private final AgenceService agenceService;
    private final UserService userService;

    public DossierService(DossierRepository dossierRepository, AgenceService agenceService, UserService userService) {
        this.dossierRepository = dossierRepository;
        this.agenceService = agenceService;
        this.userService = userService;
    }

    public DossierResponse create(DossierRequest request) {
        Agence agence = agenceService.findEntityById(request.getAgenceId());
        User createur = userService.findEntityById(request.getCreateurId());

        Dossier dossier = new Dossier();
        dossier.setReference(generateReference());
        dossier.setOrigine(request.getOrigine());
        dossier.setObjet(request.getObjet());
        dossier.setResume(request.getResume());
        dossier.setAttente(request.getAttente());
        dossier.setPriorite(request.getPriorite());
        dossier.setStatut(DossierStatus.ENREGISTRE);
        dossier.setDateReception(request.getDateReception());
        dossier.setDateEcheance(request.getDateEcheance());
        dossier.setDirectionCible(request.getDirectionCible());
        dossier.setServiceCible(request.getServiceCible());
        dossier.setAgence(agence);
        dossier.setCreateur(createur);

        return mapToResponse(dossierRepository.save(dossier));
    }

    @Transactional(readOnly = true)
    public List<DossierResponse> findAll() {
        List<Dossier> dossiers = dossierRepository.findAll();
        List<DossierResponse> responses = new ArrayList<>();
        for (Dossier dossier : dossiers) {
            responses.add(mapToResponse(dossier));
        }
        return responses;
    }

    @Transactional(readOnly = true)
    public List<DossierResponse> findByAgence(Long agenceId) {
        List<Dossier> dossiers = dossierRepository.findByAgenceIdOrderByCreatedAtDesc(agenceId);
        List<DossierResponse> responses = new ArrayList<>();
        for (Dossier dossier : dossiers) {
            responses.add(mapToResponse(dossier));
        }
        return responses;
    }

    public DossierResponse updateStatus(Long dossierId, DossierStatus statut, String retourDg) {
        Dossier dossier = findEntityById(dossierId);
        dossier.setStatut(statut);
        dossier.setRetourDg(retourDg);
        return mapToResponse(dossierRepository.save(dossier));
    }

    @Transactional(readOnly = true)
    public Dossier findEntityById(Long id) {
        return dossierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dossier introuvable : " + id));
    }

    private String generateReference() {
        long nextNumber = dossierRepository.count() + 1;
        return "BNPE-DS-" + String.format("%05d", nextNumber);
    }

    private DossierResponse mapToResponse(Dossier dossier) {
        DossierResponse response = new DossierResponse();
        response.setId(dossier.getId());
        response.setReference(dossier.getReference());
        response.setOrigine(dossier.getOrigine());
        response.setObjet(dossier.getObjet());
        response.setResume(dossier.getResume());
        response.setAttente(dossier.getAttente());
        response.setPriorite(dossier.getPriorite());
        response.setStatut(dossier.getStatut());
        response.setDateReception(dossier.getDateReception());
        response.setDateEcheance(dossier.getDateEcheance());
        response.setDirectionCible(dossier.getDirectionCible());
        response.setServiceCible(dossier.getServiceCible());
        response.setRetourDg(dossier.getRetourDg());
        response.setAgenceId(dossier.getAgence().getId());
        response.setAgenceNom(dossier.getAgence().getNom());
        response.setCreateurId(dossier.getCreateur().getId());
        response.setCreateurNom(dossier.getCreateur().getNomComplet());
        response.setCreatedAt(dossier.getCreatedAt());
        response.setUpdatedAt(dossier.getUpdatedAt());
        return response;
    }
}