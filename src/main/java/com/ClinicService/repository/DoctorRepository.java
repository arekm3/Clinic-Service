package com.ClinicService.repository;

import com.ClinicService.model.Docktor;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository {
    Docktor findById(int id);
}
