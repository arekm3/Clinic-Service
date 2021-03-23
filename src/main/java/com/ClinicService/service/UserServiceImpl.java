package com.ClinicService.service;

import com.ClinicService.dto.DoctorDto;
import com.ClinicService.dto.PatientDto;
import com.ClinicService.model.Doctor;
import com.ClinicService.model.Patient;
import com.ClinicService.model.Role;
import com.ClinicService.model.User;
import com.ClinicService.repository.DoctorRepository;
import com.ClinicService.repository.PatientRepository;
import com.ClinicService.repository.RoleRepository;
import com.ClinicService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PatientRepository patientRepository;



    @Override
    public void saveDoctor(DoctorDto doctorDto) {
        Doctor doctor = toDoctor(doctorDto);
        User saved = userRepository.save(doctor.getUser());
        doctor.setUser(saved);
        doctorRepository.save(doctor);
    }

    @Override
    public void savePatient(PatientDto patientDto) {
        Patient patient = toPatient(patientDto);
        User saved = userRepository.save(patient.getUser());
        patient.setUser(saved);
     patientRepository.save(patient);
    }

    private Patient toPatient(PatientDto patientDto) {
        return Patient.builder()
                .name(patientDto.getName())
                .lastName(patientDto.getLastName())
                .address(patientDto.getAddress())
                .email(patientDto.getEmail())
                .gender(patientDto.getGender())
                .user(createUser(patientDto.getName(), patientDto.getPassword(),Set.of(roleRepository.findByName("user"))))
                .build();
    }

    private Doctor toDoctor(DoctorDto doctorDto) {
        return Doctor.builder()
                .name(doctorDto.getName())
                .lastName(doctorDto.getLastName())
                .specialization(doctorDto.getSpecialization())
                .user(createUser(doctorDto.getName(), doctorDto.getPassword(),Set.of(roleRepository.findByName("admin"))))
                .build();
    }

    private User createUser(String name, String password, Set<Role> role) {
        return new User(null, name, passwordEncoder.encode(password), role);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUserName(s).orElseThrow(()-> new UsernameNotFoundException("Couldn't find user by user name"));
    }

//    public static void main(String[] args) {
//        System.out.println(new BCryptPasswordEncoder().encode("test"));
//    }
}
