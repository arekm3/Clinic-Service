package com.ClinicService.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    private Date date;
}
