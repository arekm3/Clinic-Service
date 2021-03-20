package com.ClinicService.repository;

import com.ClinicService.model.Doctor;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository {
    Doctor findById(int id);
}
