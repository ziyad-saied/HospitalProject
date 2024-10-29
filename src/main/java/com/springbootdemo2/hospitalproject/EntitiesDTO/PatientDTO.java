package com.springbootdemo2.hospitalproject.EntitiesDTO;

import com.springbootdemo2.hospitalproject.Entities.Patient;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

//    private Integer patientID;
    private String name;
    private String gender;
    private Integer age;
//    private Date dob;
    private Integer mobile;
    private Integer roomid;

    public static PatientDTO toDto(Patient patient) {
        return PatientDTO.builder()
                .name(patient.getName())
                .gender(patient.getGender())
                .age(patient.getAge())
                .mobile(patient.getMobile())
                .roomid(patient.getRoomid())
                .build();
    }

    public static List<PatientDTO> toDtoList(List<Patient> patients) {
        List<PatientDTO> patientDTOs = new ArrayList<>();
        for (Patient patient : patients) {
            patientDTOs.add(toDto(patient));
        }
        return patientDTOs;
    }
}
