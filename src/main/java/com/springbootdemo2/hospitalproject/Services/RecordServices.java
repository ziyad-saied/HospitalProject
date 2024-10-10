package com.springbootdemo2.hospitalproject.Services;

import com.springbootdemo2.hospitalproject.Entities.Records;
import com.springbootdemo2.hospitalproject.Repositories.RecordRepo;
import com.springbootdemo2.hospitalproject.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordServices {
    @Autowired
    private RecordRepo recordRepo;

    //Add Record
    public Records addRecords(Records record) {
        return this.recordRepo.save(record);
    }

    //Get All Record
    public List<Records> getAllRecords() {
        return this.recordRepo.findAll();
    }

    //Get Record By Id
    public Records getRecordById(Integer id) {
        Optional<Records> record = this.recordRepo.findById(id);
        if (record.isPresent()) {
            return record.get();
        }else {
            throw new ResourceNotFoundException("Record with id " + id + " not found, please enter a valid id");
        }
    }

    //Update Data Record
    public Records updateRecordById(int id, Records record) {
        Optional<Records> recordOptional = this.recordRepo.findById(id);
        if (recordOptional.isPresent()) {
            Records updatedRecord = recordOptional.get();
            if((record.getRecordNo() != null))
                updatedRecord.setRecordNo(record.getRecordNo());
            if (record.getAppNo() != null)
                updatedRecord.setAppNo(record.getAppNo());
            return recordRepo.save(updatedRecord);
        }else {
            throw new ResourceNotFoundException("Record with id " + id + " not found, please enter a valid id");
        }
    }

    //Delete Records
    public ResponseEntity<String> deleteRecordById(int id) {
        Optional<Records> record = this.recordRepo.findById(id);
        if (record.isPresent()) {
            recordRepo.deleteById(id);
            return ResponseEntity.ok("Record with id " + id + " deleted successfully");
        }else {
            throw new ResourceNotFoundException("Record with id " + id + " not found, please enter a valid id");
        }
    }

    //Delete All Records
    public ResponseEntity<String> deleteAllRecords() {
        this.recordRepo.deleteAll();
        return ResponseEntity.ok("All records deleted successfully");
    }
}
