package com.ClinicService.service;

import com.ClinicService.dto.VisitDto;
import com.ClinicService.model.Visit;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface VisitService {
    void createVisit(Visit visit);
    void displayVisitDetails(Visit visit);
    List<VisitDto> getAvailableVisit(LocalDate dateTime, int id);
}
