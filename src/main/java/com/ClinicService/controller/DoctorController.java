package com.ClinicService.controller;

import com.ClinicService.dto.DoctorDto;
import com.ClinicService.model.Doctor;
import com.ClinicService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

public class DoctorController {

    @Autowired
    UserService userService;

    @GetMapping("/doctor/register")
    public String registerDocPage(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctor/register";
    }

    @PostMapping("/doctor/register")
    public String registerDoc(@Valid DoctorDto doc, BindingResult result) {
        if (result.hasErrors()) {
            return "doctor/register";
        } else {
            userService.saveDoctor(doc);
            return "redirect:/login";
        }
    }
}
