package com.springbootdemo2.hospitalproject.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "nurse")
public class Nurse extends Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nurse_id")
    private int nurseId;

    @ManyToMany
    @JoinTable(
            name = "nurse_governs_rooms",
            joinColumns = @JoinColumn(name = "nurse_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id")
    )
    private List<Rooms> rooms;
}
