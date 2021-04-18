package com.ClinicService.dto.visitdto;

import com.ClinicService.dto.patientdto.PatientDto;
import com.ClinicService.dto.doctordto.DoctorFullDto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class VisitFullDto {

    private DoctorFullDto doctor;
    private LocalDateTime date;
    private PatientDto patient;
}
