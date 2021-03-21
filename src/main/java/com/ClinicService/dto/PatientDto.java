package com.ClinicService.dto;

import com.ClinicService.model.EGender;
import lombok.Data;

@Data
public class PatientDto {

    private String name;
    private String lastName;
    private String email;
    private String address;
    private EGender gender;
    private String userName;
    private String password;
}
