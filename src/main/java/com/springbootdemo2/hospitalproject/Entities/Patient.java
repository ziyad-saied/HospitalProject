package com.springbootdemo2.hospitalproject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient")
public class Patient {
    @Id
    @Column(name = "P-ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientID;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private Integer age;
    @Column(name = "dateOfBirth")
    private Date dob;
    @Column(name = "Mob_No")
    private Integer mobile;


    @OneToMany(mappedBy = "patientEntity")
    @JsonIgnore
    @JsonManagedReference
    private List<Bills> bills;
}
