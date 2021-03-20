package com.ClinicService.repository;

import com.ClinicService.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Page<Patient> findAll(Pageable pageable);
    Patient findById(int id);

}
