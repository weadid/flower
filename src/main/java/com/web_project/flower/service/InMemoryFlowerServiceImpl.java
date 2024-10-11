package com.web_project.flower.service;

import com.web_project.flower.model.FlowerModel;
import com.web_project.flower.repository.FlowerRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class InMemoryFlowerServiceImpl implements FlowerService{

    private final FlowerRepository flowerRepository;

    public InMemoryFlowerServiceImpl(FlowerRepository flowerRepository){
        this.flowerRepository = flowerRepository;
    }


    @Override
    public List<FlowerModel> findAllFlowers() {
        return flowerRepository.findAll(Sort.by("id"));
    }


    @Override
    public FlowerModel findFlowerById(UUID id) {

        return flowerRepository.findById(id).orElse(null);
    }

    @Override
    public FlowerModel addFlower(FlowerModel flower) {

        return flowerRepository.save(flower);
    }

    @Override
    public FlowerModel updateFlower(FlowerModel flower) {
        if(flowerRepository.existsById(flower.getId())) {
            return flowerRepository.save(flower);
        }
        return null;
    }

    @Override
    public void deleteFlower(UUID id) {
        if(flowerRepository.existsById(id)) {
            flowerRepository.deleteById(id);
        }
    }
}
