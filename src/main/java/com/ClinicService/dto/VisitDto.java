package com.ClinicService.dto;

import com.ClinicService.model.Doctor;
import com.ClinicService.model.Patient;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VisitDto {

    private Doctor id;
    private LocalDateTime date;
    private Patient patient;
}
