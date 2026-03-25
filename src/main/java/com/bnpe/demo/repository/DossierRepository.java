package com.bnpe.demo.repository;

import com.bnpe.demo.model.Dossier;
import com.bnpe.demo.model.DossierPriority;
import com.bnpe.demo.model.DossierStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DossierRepository extends JpaRepository<Dossier, Long> {
    List<Dossier> findByAgenceIdOrderByCreatedAtDesc(Long agenceId);
    long countByPriorite(DossierPriority priorite);
    long countByStatut(DossierStatus statut);
    long countByDateEcheanceBeforeAndStatutNot(LocalDate date, DossierStatus statut);
}
