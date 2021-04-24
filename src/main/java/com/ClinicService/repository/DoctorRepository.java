package com.ClinicService.repository;

import com.ClinicService.model.Doctor;
import com.ClinicService.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Optional<Doctor> findByUserUserName(String userName);
}
