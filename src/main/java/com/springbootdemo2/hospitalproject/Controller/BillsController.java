package com.springbootdemo2.hospitalproject.Controller;

import com.springbootdemo2.hospitalproject.Entities.Bills;
import com.springbootdemo2.hospitalproject.Services.BillsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bill")
public class BillsController {

    @Autowired
    private BillsServices billsServices;

    //Get All Bills
    @GetMapping("getAllBills")
    public List<Bills> getAllBills() {
        return billsServices.getAllBills();
    }
    //Get Bill By Id
    @GetMapping("/getBillById")
    public Bills getBillById(int id) {
        return billsServices.getBillById(id);
    }
    //Delete Bill By Id
    @DeleteMapping("deleteBillById")
    public void deleteBillById(@RequestParam int id) {
        this.billsServices.DeleteBillById(id);
    }
    //Insert Bill
    @PostMapping("/addBills")
    public Bills AddBill(@RequestBody Bills bills) {
        return this.billsServices.AddBill(bills);
    }
    //Update Bill By Id
    @PutMapping("/updateBillById")
    public Bills updateBillById(@RequestParam int id,@RequestBody Bills bills) {
        return this.billsServices.updateBill(id,bills);
    }
}
