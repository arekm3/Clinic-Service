package com.ClinicService.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAT_ID")
    private int id;
    @Column(name = "PAT_NAME")
    private String name;
    @Column(name = "PAT_LASTNAME")
    private String lastName;
    @Column(name = "PAT_ADDRESS")
    private String address;
    @Column(name = "PAT_EMAIL")
    private String email;
    @Column(name = "PAT_GENDER")
    private Gender gender;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PAT_USR_ID", referencedColumnName = "USR_ID")
    private User user;
}
