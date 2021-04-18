package com.ClinicService.repository;

import com.ClinicService.model.Patient;
import com.ClinicService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    Optional<Patient> findByUserUserName(String userName);

}
