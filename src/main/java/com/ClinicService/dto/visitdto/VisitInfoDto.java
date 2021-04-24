package com.ClinicService.dto.visitdto;
import com.ClinicService.dto.doctordto.DoctorInfoDto;
import com.ClinicService.dto.patientdto.PatientInfoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VisitInfoDto {

    private int id;
    private DoctorInfoDto doctor;
    private LocalDateTime date;
    private PatientInfoDto patient;

}
