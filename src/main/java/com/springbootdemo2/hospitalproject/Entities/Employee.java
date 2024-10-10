package com.springbootdemo2.hospitalproject.Entities;


import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Employee {
    private String name;
    private String Gender;
    private Integer age;
    private String mobile;
    private double salary;
    private String state;
    private String city;
    private String pinno;
}
