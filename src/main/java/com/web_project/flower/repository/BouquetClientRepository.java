package com.web_project.flower.repository;

import com.web_project.flower.model.BouquetClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BouquetClientRepository extends JpaRepository<BouquetClientModel, UUID> {
}
