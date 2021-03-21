package com.ClinicService.service;

import com.ClinicService.dto.DoctorDto;
import com.ClinicService.model.Doctor;
import com.ClinicService.model.Role;
import com.ClinicService.model.User;
import com.ClinicService.repository.DoctorRepository;
import com.ClinicService.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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


    @Override
    public void saveDoctor(DoctorDto dto) {
        Doctor doctor = toDoctor(dto);
        User saved = userRepository.save(doctor.getUser());
        doctor.setUser(saved);
        doctorRepository.save(doctor);
    }

    private Doctor toDoctor(DoctorDto dto) {
        return Doctor.builder()
                .name(dto.getName())
                .lastName(dto.getLastName())
                .specialization(dto.getSpecialization())
                .user(createUser(dto.getName(), dto.getPassword()))
                .build();
    }

    private User createUser(String name, String password) {
        return new User(null, name, passwordEncoder.encode(password), Set.of(roleRepository.findByName("nazwaRoliDoktora")));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findById(s).orElseThrow(() -> new UsernameNotFoundException(""));
    }
}
