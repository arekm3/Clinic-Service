package com.ClinicService.service;

import com.ClinicService.dto.DoctorDto;
import com.ClinicService.dto.PatientDto;

public interface UserService {

    void saveDoctor(DoctorDto doctorDto);
    void savePatient(PatientDto patientDto);
}
