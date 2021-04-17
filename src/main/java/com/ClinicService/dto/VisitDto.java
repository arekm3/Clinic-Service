package com.ClinicService.dto;

import com.ClinicService.model.Doctor;
import com.ClinicService.model.Patient;
import com.ClinicService.model.Service;

import java.time.LocalDateTime;

public class VisitDto {

    private Patient patient;
    private Doctor doctor;
    private Service service;
    private LocalDateTime date;
}
