package com.ClinicService.service;

import com.ClinicService.model.Patient;

public interface PatientService {
    void createVisit();
    void save(Patient patient);
    Patient findByLogin(String login);
}
