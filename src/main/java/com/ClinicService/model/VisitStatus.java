package com.ClinicService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class VisitStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "VSS_ID")
    int id;
    @Column (name = "VSS_TIME")
    LocalTime time;
    @Column(name = "VSS_STATUS")
    int status;


}
