package com.ClinicService.service;


import com.ClinicService.dto.creatorVisits.CreatorVisitDto;
import com.ClinicService.dto.patientdto.PatientInfoDto;
import com.ClinicService.dto.visitdto.VisitDisplayInfo;
import com.ClinicService.dto.visitdto.VisitFullDto;
import com.ClinicService.dto.visitdto.VisitInfoDto;
import com.ClinicService.model.Doctor;
import com.ClinicService.model.Patient;
import com.ClinicService.model.Visit;
import com.ClinicService.repository.DoctorRepository;
import com.ClinicService.repository.PatientRepository;
import com.ClinicService.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VisitServiceImpl implements VisitService{
    private final VisitRepository visitRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public void createDataVisit(CreatorVisitDto obiektDto, String name) {

        Optional<Doctor> doctor = doctorRepository.findByUserUserName(name);
        doctor.ifPresent(doctor1 -> {
            List<Visit> list = new ArrayList<>();
            for(long i = 0; i<obiektDto.getNumberOfVisits();i++){
                Visit visit = new Visit();
                visit.setDate(obiektDto.getStartDate().plusMinutes(30*i));
                visit.setDoctor(doctor1);
                list.add(visit);
            }
            visitRepository.saveAll(list);
        });
    }

    @Override
    public List<VisitInfoDto> displayReservedVisit(LocalDate dateTime, String lastName) {
        List<Visit> visitByDoctor_lastNameAndDateBetween = visitRepository.findVisitByDoctor_LastNameAndDateBetween(lastName, dateTime.atStartOfDay(), dateTime.plusDays(1).atStartOfDay());
        return visitByDoctor_lastNameAndDateBetween.stream()
                .map(visit -> modelMapper.map(visit, VisitInfoDto.class))
                .collect(Collectors.toList());
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
    public VisitDisplayInfo displayVisit(int id) {
        return visitRepository.findById(id).map(this::visitToDisplay).orElseThrow();
    }

    @Override
    public void updateDescription(int id, String description) {
        Optional<Visit> visit = visitRepository.findById(id);
         visit.ifPresent(visit1 -> {
             visit1.setDescription(description);
             visitRepository.save(visit1);
         });
    }

    private VisitDisplayInfo visitToDisplay(Visit visit){
        return VisitDisplayInfo.builder()
                .patient(patientToInfo(visit.getPatient()))
                .id(visit.getId())
                .description(visit.getDescription())
                .build();
    }

    private PatientInfoDto patientToInfo(Patient patient){
        return PatientInfoDto.builder()
                .name(patient.getName())
                .lastName(patient.getLastName())
                .address(patient.getAddress())
                .email(patient.getEmail())
                .gender(patient.getGender())
                .phone(patient.getPhone())
                .build();
    }

    @Override
    public void saveVisit(VisitFullDto visitFullDto) {
        Visit visit = toVisit(visitFullDto);
        visitRepository.save(visit);
    }

    private Visit toVisit (VisitFullDto visitFullDto){
        return Visit.builder()
                .date(visitFullDto.getDate())
                .doctor(toDoctor(visitFullDto.getDoctorId()))
                .patient(null)
                .service(null).build();
    }

    private Doctor toDoctor(int id){
        return Doctor.builder()
                .id(id).build();
    }
}
