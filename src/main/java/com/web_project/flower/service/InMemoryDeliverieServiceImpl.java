package com.web_project.flower.service;

import com.web_project.flower.model.DeliverieModel;
import com.web_project.flower.repository.DeliverieRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class InMemoryDeliverieServiceImpl implements DeliverieService{

    private final DeliverieRepository deliverieRepository;

    public InMemoryDeliverieServiceImpl(DeliverieRepository deliverieRepository){
        this.deliverieRepository = deliverieRepository;
    }


    @Override
    public List<DeliverieModel> findAllDeliveries() {
        return deliverieRepository.findAll(Sort.by("id"));
    }


    @Override
    public DeliverieModel findDeliverieById(UUID id) {

        return deliverieRepository.findById(id).orElse(null);
    }

    @Override
    public DeliverieModel addDeliverie(DeliverieModel deliverie) {

        return deliverieRepository.save(deliverie);
    }

    @Override
    public DeliverieModel updateDeliverie(DeliverieModel deliverie) {
        if(deliverieRepository.existsById(deliverie.getId())) {
            return deliverieRepository.save(deliverie);
        }
        return null;
    }

    @Override
    public void deleteDeliverie(UUID id) {
        if(deliverieRepository.existsById(id)) {
            deliverieRepository.deleteById(id);
        }
    }
}
