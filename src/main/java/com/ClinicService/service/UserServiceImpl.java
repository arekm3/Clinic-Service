package com.ClinicService.service;

import com.ClinicService.dto.doctordto.DoctorFullDto;
import com.ClinicService.dto.patientdto.PatientDto;
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final DoctorRepository doctorRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public UserServiceImpl(DoctorRepository doctorRepository, PasswordEncoder passwordEncoder,
                           RoleRepository roleRepository, UserRepository userRepository,
                           PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public void saveDoctor(DoctorFullDto doctorDto) {
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

    @Override
    public void getUserById(int id) {
        userRepository.getUserById(id);
    }

    private Patient toPatient(PatientDto patientDto) {
        return Patient.builder()
                .name(patientDto.getName())
                .lastName(patientDto.getLastName())
                .address(patientDto.getAddress())
                .email(patientDto.getEmail())
                .gender(patientDto.getGender())
                .phone(patientDto.getPhone())
                .user(createUser(patientDto.getUserName(), patientDto.getPassword(), Set.of(roleRepository.findByName("user"))))
                .build();
    }

    private Doctor toDoctor(DoctorFullDto doctorDto) {
        return Doctor.builder()
                .name(doctorDto.getName())
                .lastName(doctorDto.getLastName())
                .specialization(doctorDto.getSpecialization())
                .user(createUser(doctorDto.getUserName(), doctorDto.getPassword(), Set.of(roleRepository.findByName("doctor"))))
                .build();
    }

    private User createUser(String name, String password, Set<Role> role) {
        return new User(null, name, passwordEncoder.encode(password), role);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUserName(s).orElseThrow(() -> new UsernameNotFoundException("Couldn't find user by user name"));
    }

//    public static void main(String[] args) {
//        System.out.println(new BCryptPasswordEncoder().encode("test"));
//    }
}
