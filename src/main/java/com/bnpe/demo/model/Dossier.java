package com.bnpe.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "dossiers")
public class Dossier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 40)
    private String reference;

    @Column(nullable = false, length = 150)
    private String origine;

    @Column(nullable = false, length = 200)
    private String objet;

    @Column(nullable = false, length = 1000)
    private String resume;

    @Column(nullable = false, length = 200)
    private String attente;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 40)
    private DossierPriority priorite;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private DossierStatus statut;

    @Column(nullable = false)
    private LocalDate dateReception;

    @Column(nullable = false)
    private LocalDate dateEcheance;

    @Column(length = 120)
    private String directionCible;

    @Column(length = 120)
    private String serviceCible;

    @Column(length = 120)
    private String retourDg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agence_id", nullable = false)
    private Agence agence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "createur_id", nullable = false)
    private User createur;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

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

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public User getCreateur() {
        return createur;
    }

    public void setCreateur(User createur) {
        this.createur = createur;
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
