package com.web_project.flower.controllers;

import com.web_project.flower.model.BouquetModel;
import com.web_project.flower.service.BouquetService;
import com.web_project.flower.service.FlowerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/bouquets")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class BouquetController {
    @Autowired
    public BouquetService bouquetService;

    @Autowired
    public FlowerService flowerService;

    @GetMapping("/all")
    public String getAllBouquets(Model model){
        model.addAttribute("bouquets",bouquetService.findAllBouquets());
        model.addAttribute("bouquet", new BouquetModel());
        model.addAttribute("flowers", flowerService.findAllFlowers());
        return  "bouquetList";
    }

    @PostMapping("/add")
    public String addBouquet(@Valid @ModelAttribute("bouquet") BouquetModel bouquet, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("bouquets", bouquetService.findAllBouquets());
            model.addAttribute("flowers", flowerService.findAllFlowers());
            return "bouquetList";
        }
        bouquetService.addBouquet(bouquet);
        return "redirect:/bouquets/all";
    }

    @PostMapping("/update")
    public String updateBouquet(@Valid @ModelAttribute("bouquet") BouquetModel bouquet, BindingResult result) {
        bouquetService.updateBouquet(bouquet);
        return "redirect:/bouquets/all";
    }

    @PostMapping("/delete")
    public String deleteBouquet(@RequestParam UUID id) {
        bouquetService.deleteBouquet(id);
        return "redirect:/bouquets/all";
    }


    @PostMapping("/all/{id}")
    public String getIdBouquet(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("bouquets", bouquetService.findBouquetById(id));
        model.addAttribute("bouquet", new BouquetModel());
        model.addAttribute("flowers", flowerService.findAllFlowers());
        return "bouquetList";
    }


}
