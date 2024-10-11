package com.web_project.flower.controllers;

import com.web_project.flower.model.BouquetClientModel;
import com.web_project.flower.service.BouquetClientService;
import com.web_project.flower.service.BouquetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/bouquetClients")
@PreAuthorize("hasAnyAuthority('USER')")
public class BouquetClientController {
    @Autowired
    public BouquetClientService bouquetClientService;


    @GetMapping("/all")
    public String getAllBouquetClients(Model model){
        model.addAttribute("bouquetClients", bouquetClientService.findAllBouquetClients());
        model.addAttribute("bouquetClient", new BouquetClientModel());
        return "bouquetClientList";
    }

    @PostMapping("/add")
    public String addBouquetClient(@Valid @ModelAttribute("bouquetClient") BouquetClientModel bouquetClient, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("bouquetClients", bouquetClientService.findAllBouquetClients());
            return "bouquetClientList";
        }
        bouquetClientService.addBouquetClient(bouquetClient);
        return "redirect:/bouquetClients/all";
    }

    @PostMapping("/update")
    public String updateBouquetClient(@Valid @ModelAttribute("bouquetClient") BouquetClientModel bouquetClient, BindingResult result) {
        bouquetClientService.updateBouquetClient(bouquetClient);
        return "redirect:/bouquetClients/all";
    }

    @PostMapping("/delete")
    public String deleteBouquetClient(@RequestParam UUID id) {
        bouquetClientService.deleteBouquetClient(id);
        return "redirect:/bouquetClients/all";
    }


    @PostMapping("/all/{id}")
    public String getIdBouquetClient(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("bouquetClients", bouquetClientService.findBouquetClientById(id));
        model.addAttribute("bouquetClient", new BouquetClientModel());
        return "bouquetClientList";
    }


}
