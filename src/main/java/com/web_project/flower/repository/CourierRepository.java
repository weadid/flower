package com.web_project.flower.repository;

import com.web_project.flower.model.CourierModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourierRepository extends JpaRepository<CourierModel, UUID> {
}
