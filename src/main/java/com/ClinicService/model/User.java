package com.ClinicService.model;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_ID")
    private Integer id;
    @Column(name = "USR_NAME")
    private String userName;
    @Column(name = "USR_PASSWORD")
    private String password;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "USR_ROL_USR_ID"), inverseJoinColumns = @JoinColumn(name = "USR_ROL_RO_ID"))
    private Set<Role> roles;
}
