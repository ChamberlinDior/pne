package com.bnpe.demo.dto;

import com.bnpe.demo.model.ActionStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ActionItemRequest {

    @NotBlank
    private String libelle;

    @NotBlank
    private String responsable;

    @NotNull
    private ActionStatus statut;

    @NotNull
    private LocalDate dateEcheance;

    @NotNull
    private Long dossierId;

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
}
