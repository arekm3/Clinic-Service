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


//    public static void main(String[] args) {
//        List<LocalDateTime> lista = new ArrayList<>();
//        LocalDateTime start = LocalDateTime.of(2021,4,21,16,30);
//        for(int i = 0; i<10;i++){
//            lista.add(start);
//            start=start.plusMinutes(30);
//        }
//    }
    }

