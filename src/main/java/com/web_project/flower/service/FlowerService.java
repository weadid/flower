package com.web_project.flower.service;

import com.web_project.flower.model.FlowerModel;

import java.util.List;
import java.util.UUID;

public interface FlowerService {

    public List<FlowerModel> findAllFlowers();

    public FlowerModel findFlowerById(UUID id);

    public FlowerModel addFlower(FlowerModel flower);

    public FlowerModel updateFlower(FlowerModel flower);

    public void deleteFlower(UUID id);
}
