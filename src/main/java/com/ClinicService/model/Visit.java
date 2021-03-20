package com.ClinicService.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Visit {

    @Id
    @Column
    private int id;
    @Column
    private int id_Patient;
    @Column
    private int id_Doctor;
    @Column
    private int id_Service;
    @Column
    private Date date;
}