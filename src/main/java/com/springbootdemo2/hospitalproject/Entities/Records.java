package com.springbootdemo2.hospitalproject.Entities;

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
@Table(name = "Records")
public class Records  extends Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "R_ID")
    private Integer recordId;

    @Column(name = "Record_no")
    private Integer recordNo;

    @Column(name = "App_no")
    private Integer appNo;

    @ManyToMany(mappedBy = "records")
    private Set<Receptionist> receptionists;
}
