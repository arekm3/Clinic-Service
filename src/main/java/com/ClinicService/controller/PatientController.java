package com.ClinicService.controller;

import com.ClinicService.dto.PatientDto;
import com.ClinicService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PatientController {

    private final UserService userService;

    @Autowired
    public PatientController(UserService userService) {
        this.userService = userService;
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
}
