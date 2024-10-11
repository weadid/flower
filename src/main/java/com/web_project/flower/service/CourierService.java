package com.web_project.flower.service;

import com.web_project.flower.model.CourierModel;

import java.util.List;
import java.util.UUID;

public interface CourierService {

    public List<CourierModel> findAllCouriers();

    public CourierModel findCourierById(UUID id);

    public CourierModel addCourier(CourierModel courier);

    public CourierModel updateCourier(CourierModel courier);

    public void deleteCourier(UUID id);
}
