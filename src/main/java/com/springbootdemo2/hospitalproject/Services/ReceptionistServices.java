package com.springbootdemo2.hospitalproject.Services;

import com.springbootdemo2.hospitalproject.Entities.Receptionist;
import com.springbootdemo2.hospitalproject.Entities.Records;
import com.springbootdemo2.hospitalproject.Repositories.ReceptionistRepo;
import com.springbootdemo2.hospitalproject.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ReceptionistServices {
    @Autowired
    private ReceptionistRepo receptionistRepo;

    //Add Receptionist
    public Receptionist addReceptionist(Receptionist receptionist) {
        return receptionistRepo.save(receptionist);
    }

    //Get All Receptionist
    public List<Receptionist> getAllReceptionists() {
        return receptionistRepo.findAll();
    }

    //Get Receptionist By Id
    public Receptionist getReceptionistById(int id) {
        Optional<Receptionist> receptionist = receptionistRepo.findById(id);
        if (receptionist.isPresent()) {
            return receptionist.get();
        }else {
            throw new ResourceNotFoundException("Receptionist with id " + id + " not found, please enter valid id");
        }
    }

    //Update Receptionist
    public Receptionist updateReceptionist(int id, Receptionist receptionist) {
        Optional<Receptionist> receptionistOptional = receptionistRepo.findById(id);
        if (receptionistOptional.isPresent()) {
            Receptionist receptionist1 = receptionist;
            if(receptionist.getName() != null)
                receptionist1.setName(receptionist.getName());
            if (receptionist.getGender() != null)
                receptionist1.setGender(receptionist.getGender());
            if (receptionist.getAge() != null)
                receptionist1.setAge(receptionist.getAge());
            if(receptionist.getCity() != null)
                receptionist1.setCity(receptionist.getCity());
            if(receptionist.getState() != null)
                receptionist1.setState(receptionist.getState());
            if (receptionist.getMobile() != null)
                receptionist1.setMobile(receptionist.getMobile());
            if(receptionist.getPinno() != null)
                receptionist1.setPinno(receptionist.getPinno());
            if(receptionist.getSalary() != 0.0)
                receptionist1.setSalary(receptionist.getSalary());
            return receptionistRepo.save(receptionist);
        }else {
            throw new ResourceNotFoundException("Receptionist with id " + id + " not found, please enter valid id");
        }
    }

    //Delete Receptionist By ID
    public ResponseEntity<String> deleteReceptionist(int id) {
        Optional<Receptionist> receptionistOptional = receptionistRepo.findById(id);
        if (receptionistOptional.isPresent()) {
            receptionistRepo.delete(receptionistOptional.get());
            return ResponseEntity.ok("Receptionist with id " + id + " deleted successfully");
        }else {
            throw new ResourceNotFoundException("Receptionist with id " + id + " not found, please enter valid id");
        }
    }

    //Delete All Receptionist
    public ResponseEntity<String> deleteAllReceptionists(){
        receptionistRepo.deleteAll();
        return ResponseEntity.ok("All receptionists deleted successfully");
    }

    //Add Records Ids
    public void addRecordIds(int id, Set<Integer> recordIds) {
        Receptionist receptionist = receptionistRepo.findById(id).get();
        Set<Records> records = new HashSet<>();
        for(Integer recordId : recordIds) {
            Records record = new Records();
            record.setRecordId(recordId);
        }
        receptionist.setRecordsId(records);
        receptionistRepo.save(receptionist);
    }
}
