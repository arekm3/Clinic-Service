package com.ClinicService.service;


import com.ClinicService.dto.creatorVisits.CreatorVisitDto;
import com.ClinicService.dto.visitdto.VisitFullDto;
import com.ClinicService.dto.visitdto.VisitInfoDto;
import com.ClinicService.model.Visit;

import java.time.LocalDate;
import java.util.List;

public interface VisitService {
    void createDataVisit(CreatorVisitDto obiektDto, String name);
    void displayVisitDetails(Visit visit);
    List<VisitInfoDto> getAvailableVisit(LocalDate dateTime, String lastName);
    void addPatientToVisit(int id, String name);
    void saveVisit(VisitFullDto visitFullDto);

}
