package com.web_project.flower.service;

import com.web_project.flower.model.CourierModel;
import com.web_project.flower.repository.CourierRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class InMemoryCourierServiceImpl implements CourierService{

    private final CourierRepository courierRepository;

    public InMemoryCourierServiceImpl(CourierRepository courierRepository){
        this.courierRepository = courierRepository;
    }


    @Override
    public List<CourierModel> findAllCouriers() {
        return courierRepository.findAll(Sort.by("id"));
    }


    @Override
    public CourierModel findCourierById(UUID id) {

        return courierRepository.findById(id).orElse(null);
    }

    @Override
    public CourierModel addCourier(CourierModel courier) {

        return courierRepository.save(courier);
    }

    @Override
    public CourierModel updateCourier(CourierModel courier) {
        if(courierRepository.existsById(courier.getId())) {
            return courierRepository.save(courier);
        }
        return null;
    }

    @Override
    public void deleteCourier(UUID id) {
        if(courierRepository.existsById(id)) {
            courierRepository.deleteById(id);
        }
    }
}
