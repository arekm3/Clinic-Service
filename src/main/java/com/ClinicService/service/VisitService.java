package com.ClinicService.service;

import com.ClinicService.model.Visit;

import java.time.LocalDateTime;
import java.util.List;

public interface VisitService {
    void createVisit(Visit visit);
    void displayVisitDetails(Visit visit);
    List<Visit> displayAvanaibleVisit(LocalDateTime dateTime, int id);
}
