package com.bnpe.demo.repository;

import com.bnpe.demo.model.ActionItem;
import com.bnpe.demo.model.ActionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActionItemRepository extends JpaRepository<ActionItem, Long> {
    List<ActionItem> findByDossierIdOrderByCreatedAtDesc(Long dossierId);
    long countByStatut(ActionStatus statut);
}
