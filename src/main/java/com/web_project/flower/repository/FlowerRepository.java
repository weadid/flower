package com.web_project.flower.repository;

import com.web_project.flower.model.FlowerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FlowerRepository extends JpaRepository<FlowerModel, UUID> {
}
