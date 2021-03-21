package com.ClinicService.dto;

import lombok.Data;

@Data
public class PatientDto {

    private String name;
    private String lastName;
    private String email;
    private String address;
    private String gender;
    private String userName;
    private String password;
}
