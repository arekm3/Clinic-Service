package com.ClinicService.dto;

import com.ClinicService.model.User;
import lombok.Data;

@Data
public class DoctorDto {

    private String name;
    private String lastName;
    private String specialization;
    private String userName;
    private String password;
}
