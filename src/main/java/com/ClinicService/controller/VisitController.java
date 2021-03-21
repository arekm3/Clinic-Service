package com.ClinicService.controller;

import com.ClinicService.model.Visit;
import com.ClinicService.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

public class VisitController {

    @Autowired
    VisitService visitService;

    @GetMapping("/patient/create_visit")
    public String createVisitPage(Model model){
        model.addAttribute("visit", new Visit());
        return "home/success";
    }

    @PostMapping("/patient/create_visit")
    public String createVisit(@Valid Visit visit, BindingResult result){
        if (result.hasErrors()){
            return "patient/create_visit";
        }
        else {
            visitService.createVisit(visit);
            return "redirect:/login";
        }
    }
}
