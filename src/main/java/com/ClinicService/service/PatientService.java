package com.ClinicService.service;

import com.ClinicService.dto.patientdto.PatientDto;
import com.ClinicService.model.Patient;

public interface PatientService {

    void displayPatientDetails(Patient patient);
    PatientDto findByUserNamePatient(String userName);
    void updatePatient(PatientDto patientDto);
}
