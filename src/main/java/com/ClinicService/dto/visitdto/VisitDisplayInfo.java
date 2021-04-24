package com.ClinicService.dto.visitdto;

import com.ClinicService.dto.patientdto.PatientInfoDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VisitDisplayInfo {

    private int id;
    private PatientInfoDto patient;
    private String description;


    @Override
    public String toString() {
        return "patient: " + patient + "description: " + description;
    }
}
