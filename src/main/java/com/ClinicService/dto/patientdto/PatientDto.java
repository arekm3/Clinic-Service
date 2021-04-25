package com.ClinicService.dto.patientdto;

import com.ClinicService.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientDto {

    private int id;
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
