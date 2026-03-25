package com.bnpe.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class AgenceRequest {

    @NotBlank
    private String code;

    @NotBlank
    private String nom;

    @NotBlank
    private String ville;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
