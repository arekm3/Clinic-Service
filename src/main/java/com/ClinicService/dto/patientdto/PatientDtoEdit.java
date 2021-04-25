package com.ClinicService.dto.patientdto;

import lombok.Data;

@Data
public class PatientDtoEdit {
    private String email;
    private String userName;
    private String password;
    private String phone;
}
