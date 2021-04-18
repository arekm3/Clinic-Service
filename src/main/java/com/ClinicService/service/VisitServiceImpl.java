package com.ClinicService.service;


import com.ClinicService.dto.visitdto.VisitFullDto;
import com.ClinicService.dto.visitdto.VisitInfoDto;
import com.ClinicService.model.Patient;
import com.ClinicService.model.Visit;
import com.ClinicService.repository.PatientRepository;
import com.ClinicService.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VisitServiceImpl implements VisitService{
    private final VisitRepository visitRepository;
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public void createVisit(Visit visit) {
    }

    @Override
    public void displayVisitDetails(Visit visit) {
    }
    @Override
    public List<VisitInfoDto> getAvailableVisit(LocalDate dateTime, String lastName) {
        List<Visit> visitByDoctor_lastNameAndDateBetween = visitRepository.findVisitByDoctor_LastNameAndDateBetween(lastName, dateTime.atStartOfDay(), dateTime.plusDays(1).atStartOfDay());
        return visitByDoctor_lastNameAndDateBetween.stream()
                .map(visit -> modelMapper.map(visit, VisitInfoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addPatientToVisit(int id, String name) {
        Optional<Patient> patient = patientRepository.findByUserUserName(name);
        Optional<Visit> visit = visitRepository.findById(id);

        visit.ifPresent(visit1 -> {
            if(patient.isPresent()){
                visit1.setPatient(patient.get());
                visitRepository.save(visit1);
            }
        });
    }

    @Override
    public void saveVisit(VisitFullDto visitFullDto) {
        VisitFullDto visit = toVisit(visitFullDto);
       // Visit saved = visitRepository.save(visit);
    }
    private VisitFullDto toVisit (VisitFullDto visitFullDto){
        return VisitFullDto.builder()
                .date(visitFullDto.getDate())
                .doctor(visitFullDto.getDoctor()).build();
    }


}
