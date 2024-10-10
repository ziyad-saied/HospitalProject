package com.springbootdemo2.hospitalproject.Entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bills")
public class Bills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Integer bid;
    @Column(name = "p_id")
    private Integer pid;
    @Column(name = "amount")
    private double amount;


    @ManyToOne
    //@JsonIgnore
    @JsonBackReference
    @JoinColumn(name = "p_id", insertable = false, updatable = false)
    private Patient patientEntity;
}
