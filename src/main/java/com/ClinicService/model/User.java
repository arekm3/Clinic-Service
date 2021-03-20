package com.ClinicService.model;


import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @Column
    private int id;
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    private String role;
}
