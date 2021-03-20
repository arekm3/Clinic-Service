package com.ClinicService.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Patient {

    @Id
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private String adress;
    @Column
    private String email;
    @Column
    private Gender gender;
    @Column
    private int id_User;
}
