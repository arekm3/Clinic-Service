package com.ClinicService.service;

import com.ClinicService.dto.doctordto.DoctorFullDto;
import com.ClinicService.dto.patientdto.PatientDto;
import com.ClinicService.model.Doctor;
import com.ClinicService.model.Patient;

public interface UserService {

    void saveDoctor(DoctorFullDto doctorDto);
    void savePatient(PatientDto patientDto);
    void getUserById(int id);

    DoctorFullDto findByLoginDoctor(String userName);

}
