package com.ClinicService.service;

import com.ClinicService.model.Patient;
import com.ClinicService.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {


    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void displayPatientDetails(Patient patient) {

    }

    @Override
    public void getPatientById(int id) {
        patientRepository.getPatientById(id);
    }
}
