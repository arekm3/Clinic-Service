package com.ClinicService.model;


import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_ID")
    private int id;
    @Column(name = "USR_NAME")
    private String userName;
    @Column(name = "USR_PASSWORD")
    private String password;
    @Column
    private Set<Rol> roles;
}
