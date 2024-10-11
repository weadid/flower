package com.web_project.flower.service;

import com.web_project.flower.model.BouquetClientModel;
import com.web_project.flower.repository.BouquetClientRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class InMemoryBouquetClientServiceImpl implements BouquetClientService{

    private final BouquetClientRepository bouquetClientRepository;

    public InMemoryBouquetClientServiceImpl(BouquetClientRepository bouquetClientRepository){
        this.bouquetClientRepository = bouquetClientRepository;
    }


    @Override
    public List<BouquetClientModel> findAllBouquetClients() {
        return bouquetClientRepository.findAll(Sort.by("id"));
    }


    @Override
    public BouquetClientModel findBouquetClientById(UUID id) {

        return bouquetClientRepository.findById(id).orElse(null);
    }

    @Override
    public BouquetClientModel addBouquetClient(BouquetClientModel bouquetClient) {

        return bouquetClientRepository.save(bouquetClient);
    }

    @Override
    public BouquetClientModel updateBouquetClient(BouquetClientModel bouquetClient) {
        if(bouquetClientRepository.existsById(bouquetClient.getId())) {
            return bouquetClientRepository.save(bouquetClient);
        }
        return null;
    }

    @Override
    public void deleteBouquetClient(UUID id) {
        if(bouquetClientRepository.existsById(id)) {
            bouquetClientRepository.deleteById(id);
        }
    }
}
