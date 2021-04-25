package com.ClinicService.dto.patientdto;

import com.ClinicService.model.Role;
import lombok.Data;

@Data
public class PatientDto {

    private String name;
    private String lastName;
    private String email;
    private String address;
    private String gender;
    private String phone;
    private String userName;
    private String password;
    private Role role;
}
