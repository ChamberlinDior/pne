package com.bnpe.demo.dto;

import com.bnpe.demo.model.DossierPriority;
import com.bnpe.demo.model.DossierStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DossierResponse {

    private Long id;
    private String reference;
    private String origine;
    private String objet;
    private String resume;
    private String attente;
    private DossierPriority priorite;
    private DossierStatus statut;
    private LocalDate dateReception;
    private LocalDate dateEcheance;
    private String directionCible;
    private String serviceCible;
    private String retourDg;
    private Long agenceId;
    private String agenceNom;
    private Long createurId;
    private String createurNom;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

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

    public DossierStatus getStatut() {
        return statut;
    }

    public void setStatut(DossierStatus statut) {
        this.statut = statut;
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

    public String getRetourDg() {
        return retourDg;
    }

    public void setRetourDg(String retourDg) {
        this.retourDg = retourDg;
    }

    public Long getAgenceId() {
        return agenceId;
    }

    public void setAgenceId(Long agenceId) {
        this.agenceId = agenceId;
    }

    public String getAgenceNom() {
        return agenceNom;
    }

    public void setAgenceNom(String agenceNom) {
        this.agenceNom = agenceNom;
    }

    public Long getCreateurId() {
        return createurId;
    }

    public void setCreateurId(Long createurId) {
        this.createurId = createurId;
    }

    public String getCreateurNom() {
        return createurNom;
    }

    public void setCreateurNom(String createurNom) {
        this.createurNom = createurNom;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
