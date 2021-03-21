package com.ClinicService.controller;

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

    @GetMapping("doctor/register")
    public String registerPage(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "/register";
    }

    @PostMapping("/register")
    public String register(@Valid Doctor doc, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        } else {
            userService.saveDoctor(doc);
            return "redirect:/login";
        }
    }
}
