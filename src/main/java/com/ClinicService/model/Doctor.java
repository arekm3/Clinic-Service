package com.ClinicService.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOC_ID")
    private int id;
    @Column(name = "DOC_NAME")
    private String name;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "SPECIALIZATION")
    private String specialization;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOC_USR_ID", referencedColumnName = "USR_ID")
    private User user;
}
