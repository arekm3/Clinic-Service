package com.ClinicService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VIS_DOC_ID", referencedColumnName = "DOC_ID")
    private Doctor doctor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VIS_SER_ID", referencedColumnName = "SER_ID")
    private Service service;
    @Column(name = "VIS_DATE")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime date;
    @Column(name="VIS_DESC")
    private String description;

    }

