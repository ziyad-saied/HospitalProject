package com.springbootdemo2.hospitalproject.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "receptionist")
public class Receptionist extends Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recep_id")
    private Integer receptionistId;

    @ManyToMany(mappedBy = "recordId" ,cascade = CascadeType.ALL)
    @JoinTable(
            name = "receptionist_maintains_records",
            joinColumns = @JoinColumn(name = "recep_id"),
            inverseJoinColumns = @JoinColumn(name = "record_id")
    )
    private Set<Records> recordsId;
}
