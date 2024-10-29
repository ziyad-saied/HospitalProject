package com.springbootdemo2.hospitalproject.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "doctor")
public class Doctor extends Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_id")
    private Integer doctorId;
    @Column(name = "dept")
    private String department;
    @Column(name = "qualification")
    private String qualification;

    @ManyToMany
    @JsonBackReference
    @JoinTable(
            name = "doctor_Consult_Patient",
            joinColumns =@JoinColumn(name = "doc_id"),
            inverseJoinColumns = @JoinColumn(name = "p-id")
    )
    private Set<Patient> patients;
}
