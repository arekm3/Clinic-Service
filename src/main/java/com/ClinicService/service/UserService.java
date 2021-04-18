package com.ClinicService.service;

import com.ClinicService.dto.doctordto.DoctorFullDto;
import com.ClinicService.dto.patientdto.PatientDto;

public interface UserService {

    void saveDoctor(DoctorFullDto doctorDto);
    void savePatient(PatientDto patientDto);
    void getUserById(int id);
}
