package com.ClinicService.service;

import com.ClinicService.model.Patient;

public interface PatientService {
    void save(Patient patient);
    void displayPatientDetails(Patient patient);
}
