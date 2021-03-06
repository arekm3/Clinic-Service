package com.ClinicService.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctor")
@Data
@Builder
public class Doctor  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOC_ID")
    private Integer id;
    @Column(name = "DOC_NAME")
    private String name;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "SPECIALIZATION")
    private String specialization;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOC_USR_ID", referencedColumnName = "USR_ID")
    private User user;
}
