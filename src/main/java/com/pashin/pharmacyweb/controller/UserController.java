package com.pashin.pharmacyweb.controller;

import com.pashin.pharmacyweb.dto.*;
import com.pashin.pharmacyweb.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private DBService dbService;

    @GetMapping("/user/getDrugInPharmacyByID")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DrugInPharmacyDTO getDrugInPharmacyByID(@RequestParam Long drugID, @RequestParam Long pharmacyID) {
        return dbService.getDrugInPharmacyByID(drugID, pharmacyID);
    }

    @GetMapping("/user/getDrugInPharmacyList")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<DrugInPharmacyDTO> getDrugInPharmacyList() {
        return dbService.getDrugInPharmacyList();
    }

    @GetMapping("/user/getDrugByID")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DrugDTO getDrugByID(@RequestParam Long drugID) {
        return dbService.getDrugByID(drugID);
    }

    @GetMapping("/user/getDrugList")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<DrugDTO> getDrugList() {
        return dbService.getDrugList();
    }

    @GetMapping("/user/getEmployeeByID")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public EmployeeDTO getEmployeeByID(@RequestParam Long employeeID) {
        return dbService.getEmployeeByID(employeeID);
    }

    @GetMapping("/user/getEmployeeList")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<EmployeeDTO> getEmployeeList() {
        return dbService.getEmployeeList();
    }

    @GetMapping("/user/getNetworkByID")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public NetworkDTO getNetworkByID(@RequestParam Long networkID) {
        return dbService.getNetworkByID(networkID);
    }

    @GetMapping("/user/getNetworkList")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<NetworkDTO> getNetworkList() {
        return dbService.getNetworkList();
    }

    @GetMapping("/user/getPharmacyByID")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PharmacyDTO getPharmacyByID(@RequestParam Long pharmacyID) {
        return dbService.getPharmacyByID(pharmacyID);
    }

    @GetMapping("/user/getPharmacyList")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<PharmacyDTO> getPharmacyList() {
        return dbService.getPharmacyList();
    }


}
