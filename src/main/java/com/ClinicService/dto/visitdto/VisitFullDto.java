package com.ClinicService.dto.visitdto;
import com.ClinicService.dto.patientdto.PatientDto;
import lombok.Data;
import java.time.LocalDateTime;

@Data
 public class VisitFullDto {
    private int doctorId;
    private LocalDateTime date;
    private PatientDto patient;
}
