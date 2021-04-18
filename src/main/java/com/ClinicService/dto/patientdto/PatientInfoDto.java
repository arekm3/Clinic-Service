package com.ClinicService.dto.patientdto;

import lombok.Data;

@Data
public class PatientInfoDto {
    private String name;
    private String lastName;
    private String email;
    private String address;
    private String gender;
    private String phone;
}
