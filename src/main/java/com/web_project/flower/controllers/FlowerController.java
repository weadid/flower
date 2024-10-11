package com.web_project.flower.controllers;

import com.web_project.flower.model.FlowerModel;
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
@RequestMapping("/flowers")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class FlowerController {
    @Autowired
    public FlowerService flowerService;

    @GetMapping("/all")
    public String getAllFlowers(Model model){
        model.addAttribute("flowers",flowerService.findAllFlowers());
        model.addAttribute("flower", new FlowerModel());
        return  "flowerList";
    }

    @PostMapping("/add")
    public String addFlower(@Valid @ModelAttribute("flower") FlowerModel flower, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("flowers", flowerService.findAllFlowers());
            return "flowerList";
        }
        flowerService.addFlower(flower);
        return "redirect:/flowers/all";
    }

    @PostMapping("/update")
    public String updateFlower(@Valid @ModelAttribute("flower") FlowerModel flower, BindingResult result) {
        flowerService.updateFlower(flower);
        return "redirect:/flowers/all";
    }

    @PostMapping("/delete")
    public String deleteFlower(@RequestParam UUID id) {
        flowerService.deleteFlower(id);
        return "redirect:/flowers/all";
    }


    @PostMapping("/all/{id}")
    public String getIdFlower(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("flowers", flowerService.findFlowerById(id));
        model.addAttribute("flower", new FlowerModel());
        return "flowerList";
    }


}
