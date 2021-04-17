package com.ClinicService.service;

import com.ClinicService.dto.VisitDto;
import com.ClinicService.model.Visit;
import com.ClinicService.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VisitServiceImpl implements VisitService{
    private final VisitRepository visitRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public void createVisit(Visit visit) {
    }

    @Override
    public void displayVisitDetails(Visit visit) {
    }
    @Override
    public List<VisitDto> getAvailableVisit(LocalDate dateTime, int id) {
        return visitRepository.findVisitByDoctor_IdAndDateBetween(id,dateTime.atStartOfDay(),dateTime.plusDays(1).atStartOfDay()).stream()
                .map(visit -> modelMapper.map(visit, VisitDto.class))
                .collect(Collectors.toList());
    }
}
