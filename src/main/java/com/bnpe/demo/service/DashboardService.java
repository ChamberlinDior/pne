package com.bnpe.demo.service;

import com.bnpe.demo.dto.DashboardResponse;
import com.bnpe.demo.model.ActionStatus;
import com.bnpe.demo.model.DossierPriority;
import com.bnpe.demo.model.DossierStatus;
import com.bnpe.demo.repository.ActionItemRepository;
import com.bnpe.demo.repository.DossierRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DashboardService {

    private final DossierRepository dossierRepository;
    private final ActionItemRepository actionItemRepository;

    public DashboardService(DossierRepository dossierRepository, ActionItemRepository actionItemRepository) {
        this.dossierRepository = dossierRepository;
        this.actionItemRepository = actionItemRepository;
    }

    public DashboardResponse getSummary() {
        DashboardResponse response = new DashboardResponse();
        response.setTotalDossiers(dossierRepository.count());
        response.setDossiersUrgents(dossierRepository.countByPriorite(DossierPriority.P1));
        response.setDossiersEnAttenteValidationDg(dossierRepository.countByStatut(DossierStatus.EN_ATTENTE_VALIDATION_DG));
        response.setDossiersClotures(dossierRepository.countByStatut(DossierStatus.CLOTURE));
        response.setDossiersEnRetard(
                dossierRepository.countByDateEcheanceBeforeAndStatutNot(LocalDate.now(), DossierStatus.CLOTURE)
        );
        response.setTotalActions(actionItemRepository.count());
        response.setActionsTerminees(actionItemRepository.countByStatut(ActionStatus.TERMINEE));
        return response;
    }
}
