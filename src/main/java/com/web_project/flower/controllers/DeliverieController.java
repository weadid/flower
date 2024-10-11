package com.web_project.flower.controllers;

import com.web_project.flower.model.DeliverieModel;
import com.web_project.flower.service.CourierService;
import com.web_project.flower.service.DeliverieService;
import com.web_project.flower.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/deliveries")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class DeliverieController {
    @Autowired
    public DeliverieService deliverieService;

    @Autowired
    public CourierService courierService;

    @Autowired
    public OrderService orderService;

    @GetMapping("/all")
    public String getAllDeliveries(Model model){
        model.addAttribute("deliveries",deliverieService.findAllDeliveries());
        model.addAttribute("deliverie", new DeliverieModel());
        model.addAttribute("couriers", courierService.findAllCouriers());
        model.addAttribute("orders", orderService.findAllOrders());
        return  "deliverieList";
    }

    @PostMapping("/add")
    public String addDeliverie(@Valid @ModelAttribute("deliverie") DeliverieModel deliverie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("deliveries", deliverieService.findAllDeliveries());
            model.addAttribute("couriers", courierService.findAllCouriers());
            model.addAttribute("orders", orderService.findAllOrders());
            return "deliverieList";
        }
        deliverieService.addDeliverie(deliverie);
        return "redirect:/deliveries/all";
    }

    @PostMapping("/update")
    public String updateDeliverie(@Valid @ModelAttribute("deliverie") DeliverieModel deliverie, BindingResult result) {
        deliverieService.updateDeliverie(deliverie);
        return "redirect:/deliveries/all";
    }

    @PostMapping("/delete")
    public String deleteDeliverie(@RequestParam UUID id) {
        deliverieService.deleteDeliverie(id);
        return "redirect:/deliveries/all";
    }


    @PostMapping("/all/{id}")
    public String getIdDeliverie(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("deliveries", deliverieService.findDeliverieById(id));
        model.addAttribute("deliverie", new DeliverieModel());
        model.addAttribute("couriers", courierService.findAllCouriers());
        model.addAttribute("orders", orderService.findAllOrders());
        return "deliverieList";
    }


}
