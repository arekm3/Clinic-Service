package com.ClinicService.controller;

import com.ClinicService.dto.creatorVisits.CreatorVisitDto;
import com.ClinicService.dto.visitdto.VisitFullDto;
import com.ClinicService.dto.visitdto.VisitInfoDto;
import com.ClinicService.service.PatientService;
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
import java.security.Principal;
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

    @GetMapping("/patient/visit/create/av")
    public String visitsList(@RequestParam("doctor.lastName") String lastName, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, Model model) {
        List<VisitInfoDto> visitList = visitService.getAvailableVisit(date, lastName);
        model.addAttribute("visits", visitList);
        return "visit";
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

    @GetMapping("/doctor/visit/display")
    public String findReservedVisits(Model model) {
        model.addAttribute("visit", new VisitInfoDto());
        return "visitDisplayForm";
    }
    @GetMapping("/doctor/visit/display/my")
    public String displayReservedVisits(@RequestParam("doctor.lastName") String lastName, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, Model model) {
        List<VisitInfoDto> visitList = visitService.displayReservedVisit(date, lastName);
        model.addAttribute("visits", visitList);
        return "reservedVisit";
    }

    @GetMapping("/doctor/visit/display/{id}")
    public String displayVisit(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("visit",visitService.displayVisit(id));
        return "visitDetail";
    }

    @GetMapping("/patient/visit")
    public String visitPage() {
        return "visit";
    }


    @GetMapping("/register/visit/{id}")
    public String editPage(@PathVariable(value = "id") int id, Principal principal) {
        visitService.addPatientToVisit(id, principal.getName());
        return "home";
    }


    @GetMapping("/patient/contact")
    public String contactPage() {
        return "contact";
    }

    @GetMapping("/visit/register")
    public String registerVisitPage(Model model) {
        model.addAttribute("visit", new VisitFullDto());
        return "registerVisit";
    }

    @PostMapping("/visit/register")
    public String registerPatient(@Valid VisitFullDto visit, BindingResult result) {
        if (result.hasErrors()) {
            return "registerVisit";
        }

        visitService.saveVisit(visit);
        return "redirect:/login";
    }

    @GetMapping("/doctor/visit/create")
    public String epmptyVisitPage(Model model) {
        model.addAttribute("creator", new CreatorVisitDto());
        return "emptyVisit";
    }

    @PostMapping("/doctor/visit/create")
    public String addEmptyVisits(@Valid CreatorVisitDto creator, Principal principal, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "emptyVisit";
        }
        visitService.createDataVisit(creator, principal.getName());
        return "home";
    }

}
