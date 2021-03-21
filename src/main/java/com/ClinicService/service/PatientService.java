package com.ClinicService.service;

import com.ClinicService.model.Patient;

public interface PatientService {
    void savePatient(Patient patient);
    void displayPatientDetails(Patient patient);
}
