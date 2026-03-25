package com.bnpe.demo.dto;

import com.bnpe.demo.model.DossierPriority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class DossierRequest {

    @NotBlank
    private String origine;

    @NotBlank
    private String objet;

    @NotBlank
    private String resume;

    @NotBlank
    private String attente;

    @NotNull
    private DossierPriority priorite;

    @NotNull
    private LocalDate dateReception;

    @NotNull
    private LocalDate dateEcheance;

    @NotBlank
    private String directionCible;

    private String serviceCible;

    @NotNull
    private Long agenceId;

    @NotNull
    private Long createurId;

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getAttente() {
        return attente;
    }

    public void setAttente(String attente) {
        this.attente = attente;
    }

    public DossierPriority getPriorite() {
        return priorite;
    }

    public void setPriorite(DossierPriority priorite) {
        this.priorite = priorite;
    }

    public LocalDate getDateReception() {
        return dateReception;
    }

    public void setDateReception(LocalDate dateReception) {
        this.dateReception = dateReception;
    }

    public LocalDate getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(LocalDate dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public String getDirectionCible() {
        return directionCible;
    }

    public void setDirectionCible(String directionCible) {
        this.directionCible = directionCible;
    }

    public String getServiceCible() {
        return serviceCible;
    }

    public void setServiceCible(String serviceCible) {
        this.serviceCible = serviceCible;
    }

    public Long getAgenceId() {
        return agenceId;
    }

    public void setAgenceId(Long agenceId) {
        this.agenceId = agenceId;
    }

    public Long getCreateurId() {
        return createurId;
    }

    public void setCreateurId(Long createurId) {
        this.createurId = createurId;
    }
}
