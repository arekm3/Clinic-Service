package com.ClinicService.controller;

import com.ClinicService.dto.PatientDto;
import com.ClinicService.model.Patient;
import com.ClinicService.service.PatientService;
import com.ClinicService.service.UserService;
import com.ClinicService.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

public class PatientController {

    @Autowired
    UserService userService;

    @GetMapping("/patient/register")
    public String registerPatientPage(Model model){

        model.addAttribute("patient", new Patient());
        return "patient/register";
    }

    @PostMapping("/patient/register")
    public String registerPatient(@Valid PatientDto patient, BindingResult result){
        if (result.hasErrors()){
            return "patient/register";
        }
        else {
            userService.savePatient(patient);
            return "redirect:/login";
        }
    }
}
