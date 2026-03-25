package com.bnpe.demo.dto;

import com.bnpe.demo.model.ActionStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ActionItemResponse {

    private Long id;
    private String libelle;
    private String responsable;
    private ActionStatus statut;
    private LocalDate dateEcheance;
    private Long dossierId;
    private String dossierReference;
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public ActionStatus getStatut() {
        return statut;
    }

    public void setStatut(ActionStatus statut) {
        this.statut = statut;
    }

    public LocalDate getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(LocalDate dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public Long getDossierId() {
        return dossierId;
    }

    public void setDossierId(Long dossierId) {
        this.dossierId = dossierId;
    }

    public String getDossierReference() {
        return dossierReference;
    }

    public void setDossierReference(String dossierReference) {
        this.dossierReference = dossierReference;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
