package com.ClinicService.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

@Entity
@Builder
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
    @Column(name = "PAT_PHONE")
    private String phone;
    @Column(name = "PAT_GENDER")
    private String gender;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PAT_USR_ID", referencedColumnName = "USR_ID")
    private User user;
}
