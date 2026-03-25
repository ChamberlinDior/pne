package com.bnpe.demo.service;

import com.bnpe.demo.dto.AgenceRequest;
import com.bnpe.demo.dto.AgenceResponse;
import com.bnpe.demo.exception.ResourceNotFoundException;
import com.bnpe.demo.model.Agence;
import com.bnpe.demo.repository.AgenceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgenceService {

    private final AgenceRepository agenceRepository;

    public AgenceService(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    public AgenceResponse create(AgenceRequest request) {
        Agence agence = new Agence();
        agence.setCode(request.getCode());
        agence.setNom(request.getNom());
        agence.setVille(request.getVille());
        agence.setActif(true);
        return mapToResponse(agenceRepository.save(agence));
    }

    public List<AgenceResponse> findAll() {
        List<Agence> agences = agenceRepository.findAll();
        List<AgenceResponse> responses = new ArrayList<>();
        for (Agence agence : agences) {
            responses.add(mapToResponse(agence));
        }
        return responses;
    }

    public Agence findEntityById(Long id) {
        return agenceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agence introuvable : " + id));
    }

    private AgenceResponse mapToResponse(Agence agence) {
        AgenceResponse response = new AgenceResponse();
        response.setId(agence.getId());
        response.setCode(agence.getCode());
        response.setNom(agence.getNom());
        response.setVille(agence.getVille());
        response.setActif(agence.isActif());
        return response;
    }
}
