package com.springbootdemo2.hospitalproject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rooms")
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Integer rid;

    @Column(name = "type")
    private String type;
    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "availability")
    private boolean availability;

    @OneToMany(mappedBy = "RoomEntity")
    @JsonIgnore
    @JsonManagedReference
    public List<Patient> patients;
}
