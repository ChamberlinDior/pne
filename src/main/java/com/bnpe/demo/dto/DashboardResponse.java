package com.bnpe.demo.dto;

public class DashboardResponse {

    private long totalDossiers;
    private long dossiersUrgents;
    private long dossiersEnAttenteValidationDg;
    private long dossiersClotures;
    private long dossiersEnRetard;
    private long totalActions;
    private long actionsTerminees;

    public long getTotalDossiers() {
        return totalDossiers;
    }

    public void setTotalDossiers(long totalDossiers) {
        this.totalDossiers = totalDossiers;
    }

    public long getDossiersUrgents() {
        return dossiersUrgents;
    }

    public void setDossiersUrgents(long dossiersUrgents) {
        this.dossiersUrgents = dossiersUrgents;
    }

    public long getDossiersEnAttenteValidationDg() {
        return dossiersEnAttenteValidationDg;
    }

    public void setDossiersEnAttenteValidationDg(long dossiersEnAttenteValidationDg) {
        this.dossiersEnAttenteValidationDg = dossiersEnAttenteValidationDg;
    }

    public long getDossiersClotures() {
        return dossiersClotures;
    }

    public void setDossiersClotures(long dossiersClotures) {
        this.dossiersClotures = dossiersClotures;
    }

    public long getDossiersEnRetard() {
        return dossiersEnRetard;
    }

    public void setDossiersEnRetard(long dossiersEnRetard) {
        this.dossiersEnRetard = dossiersEnRetard;
    }

    public long getTotalActions() {
        return totalActions;
    }

    public void setTotalActions(long totalActions) {
        this.totalActions = totalActions;
    }

    public long getActionsTerminees() {
        return actionsTerminees;
    }

    public void setActionsTerminees(long actionsTerminees) {
        this.actionsTerminees = actionsTerminees;
    }
}
