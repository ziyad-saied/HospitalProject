package com.springbootdemo2.hospitalproject.Controller;

import com.springbootdemo2.hospitalproject.Entities.TestReport;
import com.springbootdemo2.hospitalproject.Services.TestReportServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("testReport")
public class TestReportController {

    @Autowired
    private TestReportServices testReportServices;

    //Get All Reports
    @GetMapping("/getAllReports")
    public List<TestReport> getTestReport() {
        return this.testReportServices.getAllTestReports();
    }

    //Get Report By Id
    @GetMapping("/getReportById")
    public TestReport getTestReportById(@RequestParam int id) {
        return this.testReportServices.getTestReportById(id);
    }

    //Add Report
    @PostMapping("/addReport")
    public TestReport addTestReport(@RequestBody TestReport testReport) {
        return this.testReportServices.addTestReport(testReport);
    }

    //Update Report
    @PutMapping("/updateReport")
    public TestReport updateTestReport(@RequestParam Integer id,@RequestBody TestReport testReport) {
        return this.testReportServices.updateTestReport(id,testReport);
    }

    //Delete Report By Id
    @DeleteMapping("/deleteReportById")
    public void deleteTestReportById(@RequestParam int id) {
        this.testReportServices.deleteTestReport(id);
    }

    //Delete All Report
    @DeleteMapping("/deleteAllReport")
    public void deleteAllTestReports() {
        this.testReportServices.deleteAllReports();
    }


}
