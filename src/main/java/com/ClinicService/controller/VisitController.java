package com.ClinicService.controller;

import com.ClinicService.dto.VisitDto;
import com.ClinicService.model.Visit;
import com.ClinicService.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class VisitController {

    private final VisitService visitService;

    @Autowired
    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping("/patient/visit/create")
    public String createVisitPage(Model model) {
        model.addAttribute("visit", new Visit());
        return "visitRegister";
    }

    @RequestMapping("/patient/visit/create")
    public String visitsList(@RequestParam("id") int id, @RequestParam("date") LocalDate date, Model model){
        List<VisitDto> visitList = visitService.getAvailableVisit(date,id);
        model.addAttribute("visitList", visitList);
        return "visit";
    }


    @GetMapping("/patient/visit")
    public String visitPage() {
        return "visit";
    }

    @PostMapping("/patient/visit")
    public String visit(@Valid Visit visit, BindingResult result) {
        if (result.hasErrors()) {
            return "patient/visit";
        }

        visitService.createVisit(visit);
        return "redirect:/login";
    }

    @GetMapping("/patient/contact")
    public String contactPage() {
        return "contact";
    }
}
