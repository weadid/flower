package com.web_project.flower.controllers;

import com.web_project.flower.model.CourierModel;
import com.web_project.flower.service.CourierService;
import com.web_project.flower.service.DeliverieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/couriers")
@PreAuthorize("hasAnyAuthority('COURIER')")
public class CourierController {
    @Autowired
    public CourierService courierService;

    @Autowired
    public DeliverieService deliverieService;

    @GetMapping("/all")
    public String getAllCouriers(Model model){
        model.addAttribute("couriers", courierService.findAllCouriers());
        model.addAttribute("courier", new CourierModel());
        return "courierList";
    }

    @PostMapping("/add")
    public String addCourier(@Valid @ModelAttribute("courier") CourierModel courier, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("couriers", courierService.findAllCouriers());
            model.addAttribute("deliveries", deliverieService.findAllDeliveries());
            return "courierList";
        }
        courierService.addCourier(courier);
        return "redirect:/couriers/all";
    }

    @PostMapping("/update")
    public String updateCourier(@Valid @ModelAttribute("courier") CourierModel courier, BindingResult result) {
        courierService.updateCourier(courier);
        return "redirect:/couriers/all";
    }

    @PostMapping("/delete")
    public String deleteCourier(@RequestParam UUID id) {
        courierService.deleteCourier(id);
        return "redirect:/couriers/all";
    }


    @PostMapping("/all/{id}")
    public String getIdCourier(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("couriers", courierService.findCourierById(id));
        model.addAttribute("courier", new CourierModel());
        model.addAttribute("deliveries", deliverieService.findAllDeliveries());
        return "courierList";
    }


}
