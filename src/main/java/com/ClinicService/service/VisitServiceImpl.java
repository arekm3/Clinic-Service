package com.ClinicService.service;

import com.ClinicService.model.Visit;
import com.ClinicService.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitServiceImpl implements VisitService{
    private final VisitRepository visitRepository;
    @Override
    public void createVisit(Visit visit) {

    }

    @Override
    public void displayVisitDetails(Visit visit) {

    }

    @Override
    public List<Visit> displayAvanaibleVisit(LocalDateTime dateTime, int id) {
        return visitRepository.findVisitByDateAndDoctor_Id(dateTime,id).stream().map(visit -> modelMapper.map(visit, VisitDto));
    }
}
