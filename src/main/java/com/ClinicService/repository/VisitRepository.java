package com.ClinicService.repository;

import com.ClinicService.model.Visit;

public interface VisitRepository {
    Visit getById(int id);
}
