package com.ClinicService.dto.visitdto;

import com.ClinicService.dto.patientdto.PatientInfoDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VisitDisplayInfo {
    private PatientInfoDto patient;

    @Override
    public String toString() {
        return "patient=" + patient;
    }
}
