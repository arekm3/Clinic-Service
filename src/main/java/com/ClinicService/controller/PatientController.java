package com.ClinicService.controller;

import com.ClinicService.dto.patientdto.PatientDto;
import com.ClinicService.service.PatientService;
import com.ClinicService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class PatientController {

    private final UserService userService;
    private final PatientService patientService;


    @Autowired
    public PatientController(UserService userService, PatientService patientService) {
        this.userService = userService;
        this.patientService = patientService;
    }

    @GetMapping("/patient/register")
    public String registerPatientPage(Model model) {
        model.addAttribute("patient", new PatientDto());
        return "registerPatient";
    }

    @PostMapping("/patient/register")
    public String registerPatient(@Valid PatientDto patient, BindingResult result) {
        if (result.hasErrors()) {
            return "registerPatient";
        }

        userService.savePatient(patient);
        return "redirect:/login";
    }

    @GetMapping("/patient/edit")
    public String editPatient(Model model, Principal principal) {
        PatientDto patient = patientService.findByUserNamePatient(principal.getName());
        model.addAttribute("patient", patient);
        return "editPatient";
    }

    @PostMapping("/patient/edit")
    public String updatePatient(@ModelAttribute(value = "patient") PatientDto patientDto) {
        patientService.updatePatient(patientDto);
        return "redirect:/patient/edit";
    }

}
