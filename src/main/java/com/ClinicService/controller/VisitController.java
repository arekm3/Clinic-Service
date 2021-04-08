package com.ClinicService.controller;

import com.ClinicService.model.Visit;
import com.ClinicService.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class VisitController {

    private final VisitService visitService;

    @Autowired
    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping("/patient/create_visit")
    public String createVisitPage(Model model) {
        model.addAttribute("visit", new Visit());
        return "home/success";
    }

    @PostMapping("/patient/create_visit")
    public String createVisit(@Valid Visit visit, BindingResult result) {
        if (result.hasErrors()) {
            return "patient/create_visit";
        }

        visitService.createVisit(visit);
        return "redirect:/login";
    }
}
