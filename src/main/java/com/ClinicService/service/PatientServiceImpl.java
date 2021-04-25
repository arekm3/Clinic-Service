package com.ClinicService.service;

import com.ClinicService.dto.patientdto.PatientDto;
import com.ClinicService.model.Patient;
import com.ClinicService.repository.PatientRepository;
import com.ClinicService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final UserRepository userRepository;

    @Override
    public void displayPatientDetails(Patient patient) {
    }

    @Override
    public PatientDto findByUserNamePatient(String userName) {
        Optional<Patient> patient = patientRepository.findByUserUserName(userName);
        PatientDto patientDto = patientToDTo(patient.get());
        return patientDto;
    }

    @Override
    public void updatePatient(PatientDto patientDto) {
        patientRepository.save(toPatient(patientDto));
    }

    private PatientDto patientToDTo(Patient patient){
        return PatientDto.builder()
                .id(patient.getId())
                .userName(patient.getUser().getUsername())
                .password(patient.getUser().getPassword())
                .name(patient.getName())
                .lastName(patient.getLastName())
                .address(patient.getAddress())
                .email(patient.getEmail())
                .gender(patient.getGender())
                .phone(patient.getPhone())
                .build();
    }
    private Patient toPatient(PatientDto patientDto) {
        return Patient.builder()
                .id(patientDto.getId())
                .name(patientDto.getName())
                .lastName(patientDto.getLastName())
                .address(patientDto.getAddress())
                .email(patientDto.getEmail())
                .gender(patientDto.getGender())
                .phone(patientDto.getPhone())
                .user(userRepository.findByUserName(patientDto.getUserName()).orElseThrow())
                .build();
    }

}
