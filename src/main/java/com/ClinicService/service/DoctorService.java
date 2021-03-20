package com.ClinicService.service;

import com.ClinicService.model.Patient;
import com.ClinicService.model.Visit;

public interface DoctorService {
    void displayPatientDetails(Patient patient);
    void displayVisitDetails(Visit visit);
}
