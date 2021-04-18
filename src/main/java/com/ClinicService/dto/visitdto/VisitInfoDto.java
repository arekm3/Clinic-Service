package com.ClinicService.dto.visitdto;
import com.ClinicService.dto.doctordto.DoctorInfoDto;
import com.ClinicService.dto.patientdto.PatientInfoDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VisitInfoDto {

    private int id;
    private DoctorInfoDto doctor;
    private LocalDateTime date;
    private PatientInfoDto patient;

}
