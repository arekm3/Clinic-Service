package com.ClinicService.service;

import com.ClinicService.dto.DoctorDto;
import com.ClinicService.model.Doctor;
import com.ClinicService.model.User;


public interface UserService {
    void saveDoctor(DoctorDto dto);

}
