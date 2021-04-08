package com.ClinicService.model;

import lombok.AllArgsConstructor;
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
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "visit")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VIS_ID")
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VIS_PAT_ID", referencedColumnName = "PAT_ID")
    private Patient patient;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VIS_DOC_ID", referencedColumnName = "DOC_ID")
    private Doctor doctor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VIS_SER_ID", referencedColumnName = "SER_ID")
    private Service service;
    @Column(name = "VIS_DATE")
    private LocalDate date;
}
