package com.springbootdemo2.hospitalproject.Controller;

import com.springbootdemo2.hospitalproject.Entities.Records;
import com.springbootdemo2.hospitalproject.Services.RecordServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecordController {
    @Autowired
    private RecordServices recordServices;

    //Add Record
    @PostMapping(path = "/addRecord")
    public Records addRecord(@RequestBody Records record) {
        return this.recordServices.addRecords(record);
    }

    //Get All Records
    @GetMapping(path = "/getAllRecords")
    public List<Records> getAllRecords() {
        return this.recordServices.getAllRecords();
    }

    //Get Record By Id
    @GetMapping(path = "/getRecordById")
    public Records getRecordById(@RequestParam int id) {
        return this.recordServices.getRecordById(id);
    }

    //Update Record
    @PutMapping(path = "/updateRecord")
    public Records updateRecord(@RequestParam int id,@RequestBody Records record) {
        return this.recordServices.updateRecordById(id, record);
    }

    //Delete Records By ID
    @DeleteMapping(path = "/deleteRecordById")
    public ResponseEntity<String> deleteRecordById(@RequestParam int id) {
        return this.recordServices.deleteRecordById(id);
    }

    //Delete All Records
    @DeleteMapping(path = "/deleteAllRecords")
    public ResponseEntity<String> deleteAllRecords() {
        return this.recordServices.deleteAllRecords();
    }
}
