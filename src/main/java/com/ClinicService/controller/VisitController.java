package com.ClinicService.controller;

import com.ClinicService.dto.visitdto.VisitInfoDto;
import com.ClinicService.model.Visit;
import com.ClinicService.service.PatientService;
import com.ClinicService.service.UserService;
import com.ClinicService.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class VisitController {

    private final VisitService visitService;
    private final PatientService patientService;

    @Autowired
    public VisitController(VisitService visitService, PatientService patientService) {
        this.visitService = visitService;
        this.patientService = patientService;
    }

    @GetMapping("/patient/visit/create")
    public String createVisitPage(Model model) {
        model.addAttribute("visit", new VisitInfoDto());
        return "visitRegister";
    }

//    @PostMapping("/patient/visit/create")
//    public String createVisit(@Valid Visit visit, BindingResult result) {
//        if (result.hasErrors()) {
//            return "patient/visit/create";
//        }
//
//        visitService.createVisit(visit);
//        return "redirect:/visit";
//    }

    @GetMapping("/patient/visit/create/av")
    public String visitsList(@RequestParam("doctor.lastName") String lastName, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, Model model){
        List<VisitInfoDto> visitList = visitService.getAvailableVisit(date,lastName);
        model.addAttribute("visits", visitList);
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

    @PostMapping("/register/visit/{id}")
    public String editPage(@PathVariable(value = "id") int id){

        return "post";
    }

    @GetMapping("/patient/contact")
    public String contactPage() {
        return "contact";
    }

}
