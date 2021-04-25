package com.ClinicService.service;


import com.ClinicService.dto.creatorVisits.CreatorVisitDto;
import com.ClinicService.dto.visitdto.VisitDisplayInfo;
import com.ClinicService.dto.visitdto.VisitFullDto;
import com.ClinicService.dto.visitdto.VisitInfoDto;
import com.ClinicService.model.Visit;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VisitService {
    void createDataVisit(CreatorVisitDto obiektDto, String name);
    List<VisitInfoDto> displayReservedVisit(LocalDate dateTime, String lastName);
    List<VisitInfoDto> getAvailableVisit(LocalDate dateTime, String lastName);
    void addPatientToVisit(int id, String name);
    void saveVisit(VisitFullDto visitFullDto);
    VisitDisplayInfo displayVisit(int id);
    void updateDescription(int id, String description);

}
