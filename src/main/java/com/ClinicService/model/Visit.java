package com.ClinicService.model;

import lombok.*;
import org.springframework.data.annotation.Id;

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
