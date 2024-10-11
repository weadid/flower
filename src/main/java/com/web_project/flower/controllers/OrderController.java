package com.web_project.flower.controllers;

import com.web_project.flower.model.OrderModel;
import com.web_project.flower.service.BouquetClientService;
import com.web_project.flower.service.ClientService;
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
@RequestMapping("/orders")
@PreAuthorize("hasAnyAuthority('USER')")
public class OrderController {
    @Autowired
    public OrderService orderService;

    @Autowired
    public BouquetClientService bouquetClientService;

    @Autowired
    public ClientService clientService;

    @GetMapping("/all")
    public String getAllOrders(Model model){
        model.addAttribute("orders",orderService.findAllOrders());
        model.addAttribute("order", new OrderModel());
        model.addAttribute("bouquetClients", bouquetClientService.findAllBouquetClients());
        model.addAttribute("clients", clientService.findAllClients());
        return  "orderList";
    }

    @PostMapping("/add")
    public String addOrder(@Valid @ModelAttribute("order") OrderModel order, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("orders", orderService.findAllOrders());
            model.addAttribute("bouquetClients", bouquetClientService.findAllBouquetClients());
            model.addAttribute("clients", clientService.findAllClients());
            return "orderList";
        }
        orderService.addOrder(order);
        return "redirect:/orders/all";
    }

    @PostMapping("/update")
    public String updateOrder(@Valid @ModelAttribute("order") OrderModel order, BindingResult result) {
        orderService.updateOrder(order);
        return "redirect:/orders/all";
    }

    @PostMapping("/delete")
    public String deleteOrder(@RequestParam UUID id) {
        orderService.deleteOrder(id);
        return "redirect:/orders/all";
    }


    @PostMapping("/all/{id}")
    public String getIdOrder(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("orders", orderService.findOrderById(id));
        model.addAttribute("order", new OrderModel());
        model.addAttribute("bouquetClients", bouquetClientService.findAllBouquetClients());
        model.addAttribute("clients", clientService.findAllClients());
        return "orderList";
    }


}
