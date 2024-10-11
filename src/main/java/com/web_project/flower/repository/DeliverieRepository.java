package com.web_project.flower.repository;

import com.web_project.flower.model.DeliverieModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeliverieRepository extends JpaRepository<DeliverieModel, UUID> {
}
