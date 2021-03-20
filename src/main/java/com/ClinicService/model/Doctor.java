package com.ClinicService.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "`doctor`")
public class Doctor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOC_ID")
    private int id;
    @Column(name = "DOC_NAME")
    private String name;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "ID_USER")
    private int id_User;

}
