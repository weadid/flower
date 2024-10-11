package com.web_project.flower.repository;

import com.web_project.flower.model.BouquetModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BouquetRepository extends JpaRepository<BouquetModel, UUID> {
}
