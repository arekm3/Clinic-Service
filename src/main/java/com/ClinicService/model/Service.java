package com.ClinicService.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SER_ID")
    private int id;
    @Column(name = "SER_NAME")
    private String name;
    @Column(name = "SER_TIME")
    private double time;
    @Column(name = "SER_DATE")
    private LocalDate date;
}
