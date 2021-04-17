package com.ClinicService.service;

import com.ClinicService.model.Visit;

public interface VisitService {
    void createVisit(Visit visit);
    void displayVisitDetails(Visit visit);
}
