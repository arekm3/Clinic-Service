package com.ClinicService.repository;

import com.ClinicService.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Integer> {


    List<Visit> findVisitByDateAndDoctor_Id();
}
