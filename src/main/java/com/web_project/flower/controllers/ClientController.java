package com.web_project.flower.controllers;

import com.web_project.flower.model.ClientModel;
import com.web_project.flower.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/clients")
@PreAuthorize("hasAnyAuthority('USER')")
public class ClientController {
    @Autowired
    public ClientService clientService;

    

    @GetMapping("/all")
    public String getAllClients(Model model){
        model.addAttribute("clients",clientService.findAllClients());
        model.addAttribute("client", new ClientModel());
        return  "clientList";
    }

    @PostMapping("/add")
    public String addClient(@Valid @ModelAttribute("client") ClientModel client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("clients", clientService.findAllClients());
            return "clientList";
        }
        clientService.addClient(client);
        return "redirect:/clients/all";
    }

    @PostMapping("/update")
    public String updateClient(@Valid @ModelAttribute("client") ClientModel client, BindingResult result) {
        clientService.updateClient(client);
        return "redirect:/clients/all";
    }

    @PostMapping("/delete")
    public String deleteClient(@RequestParam UUID id) {
        clientService.deleteClient(id);
        return "redirect:/clients/all";
    }


    @PostMapping("/all/{id}")
    public String getIdClient(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("clients", clientService.findClientById(id));
        model.addAttribute("client", new ClientModel());
        return "clientList";
    }


}
