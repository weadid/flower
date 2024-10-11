package com.web_project.flower.controllers;

import com.web_project.flower.model.PaymentModel;
import com.web_project.flower.service.OrderService;
import com.web_project.flower.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/payments")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class PaymentController {
    @Autowired
    public PaymentService paymentService;

    @Autowired
    public OrderService orderService;

    @GetMapping("/all")
    public String getAllPayments(Model model){
        model.addAttribute("payments",paymentService.findAllPayments());
        model.addAttribute("payment", new PaymentModel());
        model.addAttribute("orders", orderService.findAllOrders());
        return  "paymentList";
    }

    @PostMapping("/add")
    public String addPayment(@Valid @ModelAttribute("payment") PaymentModel payment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("payments", paymentService.findAllPayments());
            model.addAttribute("orders", orderService.findAllOrders());
            return "paymentList";
        }
        paymentService.addPayment(payment);
        return "redirect:/payments/all";
    }

    @PostMapping("/update")
    public String updatePayment(@Valid @ModelAttribute("payment") PaymentModel payment, BindingResult result) {
        paymentService.updatePayment(payment);
        return "redirect:/payments/all";
    }

    @PostMapping("/delete")
    public String deletePayment(@RequestParam UUID id) {
        paymentService.deletePayment(id);
        return "redirect:/payments/all";
    }


    @PostMapping("/all/{id}")
    public String getIdPayment(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("payments", paymentService.findPaymentById(id));
        model.addAttribute("payment", new PaymentModel());
        model.addAttribute("orders", orderService.findAllOrders());
        return "paymentList";
    }


}
