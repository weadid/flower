package com.web_project.flower.service;

import com.web_project.flower.model.BouquetModel;
import com.web_project.flower.repository.BouquetRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class InMemoryBouquetServiceImpl implements BouquetService{

    private final BouquetRepository bouquetRepository;

    public InMemoryBouquetServiceImpl(BouquetRepository bouquetRepository){
        this.bouquetRepository = bouquetRepository;
    }


    @Override
    public List<BouquetModel> findAllBouquets() {
        return bouquetRepository.findAll(Sort.by("id"));
    }


    @Override
    public BouquetModel findBouquetById(UUID id) {

        return bouquetRepository.findById(id).orElse(null);
    }

    @Override
    public BouquetModel addBouquet(BouquetModel bouquet) {

        return bouquetRepository.save(bouquet);
    }

    @Override
    public BouquetModel updateBouquet(BouquetModel bouquet) {
        if(bouquetRepository.existsById(bouquet.getId())) {
            return bouquetRepository.save(bouquet);
        }
        return null;
    }

    @Override
    public void deleteBouquet(UUID id) {
        if(bouquetRepository.existsById(id)) {
            bouquetRepository.deleteById(id);
        }
    }
}
