package com.ClinicService.controller;

import com.ClinicService.dto.doctordto.DoctorFullDto;
import com.ClinicService.model.Doctor;
import com.ClinicService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DoctorController {

    private final UserService userService;

    @Autowired
    public DoctorController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/doctor/register")
    public String registerDocPage(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctor/register";
    }



    @PostMapping("/doctor/register")
    public String registerDoc(@Valid DoctorFullDto doc, BindingResult result) {
        if (result.hasErrors()) {
            return "doctor/register";
        } else {
            userService.saveDoctor(doc);
            return "redirect:/login";
        }
    }
}
