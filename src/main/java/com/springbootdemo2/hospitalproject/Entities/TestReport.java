package com.springbootdemo2.hospitalproject.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "test_report")
public class TestReport {
    @Id
    @Column(name = "r_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rId;
    @Column(name = "result")
    private Integer result;
    @Column(name = "test_type")
    private String test_type;
    @Column(name = "p_id")
    private Integer pId;

    @ManyToOne
    @JsonBackReference
    @JsonIgnore
    @JoinColumn(name = "p_id", insertable = false, updatable = false)
    private Patient patientEntity;
}
