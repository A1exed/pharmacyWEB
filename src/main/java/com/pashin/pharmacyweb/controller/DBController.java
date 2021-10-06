package com.pashin.pharmacyweb.controller;

import com.pashin.pharmacyweb.dto.*;
import com.pashin.pharmacyweb.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DBController {

    @Autowired
    private DBService dbService;

    @GetMapping("/getDrugInPharmacyByID")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DrugInPharmacyDTO getDrugInPharmacyByID(@RequestParam Long drugID, @RequestParam Long pharmacyID) {
        return dbService.getDrugInPharmacyByID(drugID, pharmacyID);
    }

    @GetMapping("/getDrugInPharmacyList")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<DrugInPharmacyDTO> getDrugInPharmacyList() {
        return dbService.getDrugInPharmacyList();
    }

    @GetMapping("/addDrugInPharmacy")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DrugInPharmacyDTO addDrugInPharmacy(@RequestParam Long pharmacyID, @RequestParam Long drugID, @RequestParam Integer quantity) {
        return dbService.addDrugInPharmacy(pharmacyID, drugID, quantity);
    }

    @PostMapping("/deleteDrugInPharmacyByID")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDrugInPharmacyByID(@RequestParam Long pharmacyID, @RequestParam Long drugID) {
        dbService.deleteDrugInPharmacyByID(pharmacyID, drugID);
    }

    @GetMapping("/editDrugInPharmacy")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DrugInPharmacyDTO editDrugInPharmacy(@RequestParam Long pharmacyID, @RequestParam Long drugID, @RequestParam Integer quantity) {
        return dbService.editDrugInPharmacy(pharmacyID, drugID, quantity);
    }

    @GetMapping("/getDrugByID")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DrugDTO getDrugByID(@RequestParam Long drugID) {
        return dbService.getDrugByID(drugID);
    }

    @GetMapping("/getDrugList")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<DrugDTO> getDrugList() {
        return dbService.getDrugList();
    }

    @GetMapping("/addDrug")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DrugDTO addDrug(@RequestParam String drugName, @RequestParam String form, @RequestParam String manufacturerName) {
        return dbService.addDrug(drugName, form, manufacturerName);
    }

    @PostMapping("/deleteDrugByID")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDrugByID(@RequestParam Long drugID) {
        dbService.deleteDrugByID(drugID);
    }

    @GetMapping("/editDrug")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DrugDTO editDrug(@RequestParam Long drugID, @RequestParam String drugName, @RequestParam String form, @RequestParam String manufacturerName) {
        return dbService.editDrug(drugID, drugName, form, manufacturerName);
    }

    @GetMapping("/getEmployeeByID")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public EmployeeDTO getEmployeeByID(@RequestParam Long employeeID) {
        return dbService.getEmployeeByID(employeeID);
    }

    @GetMapping("/getEmployeeList")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<EmployeeDTO> getEmployeeList() {
        return dbService.getEmployeeList();
    }

    @GetMapping("/addEmployee")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public EmployeeDTO addEmployee(@RequestParam String employeeName, @RequestParam String position, @RequestParam String phoneNumber, @RequestParam Long pharmacyID) {
        return dbService.addEmployee(employeeName, position, phoneNumber, pharmacyID);
    }

    @PostMapping("/deleteEmployeeByID")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployeeByID(@RequestParam Long employeeID) {
        dbService.deleteEmployeeByID(employeeID);
    }

    @GetMapping("/editEmployee")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public EmployeeDTO editEmployee(@RequestParam Long employeeID, @RequestParam String employeeName, @RequestParam String position, @RequestParam String phoneNumber, @RequestParam Long pharmacyID) {
        return dbService.editEmployee(employeeID, employeeName, position, phoneNumber, pharmacyID);
    }

    @GetMapping("/getNetworkByID")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public NetworkDTO getNetworkByID(@RequestParam Long networkID) {
        return dbService.getNetworkByID(networkID);
    }

    @GetMapping("/getNetworkList")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<NetworkDTO> getNetworkList() {
        return dbService.getNetworkList();
    }

    @GetMapping("/addNetwork")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public NetworkDTO addNetwork(@RequestParam String networkName, @RequestParam String phoneNumber, @RequestParam String owner) {
        return dbService.addNetwork(networkName, phoneNumber, owner);
    }

    @PostMapping("/deleteNetworkByID")
    @ResponseStatus(HttpStatus.OK)
    public void deleteNetworkByID(@RequestParam Long networkID) {
        dbService.deleteNetworkByID(networkID);
    }

    @GetMapping("/editNetwork")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public NetworkDTO editNetwork(@RequestParam Long networkID, @RequestParam String networkName, @RequestParam String phoneNumber, @RequestParam String owner) {
        return dbService.editNetwork(networkID, networkName, phoneNumber, owner);
    }

    @GetMapping("/getPharmacyByID")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PharmacyDTO getPharmacyByID(@RequestParam Long pharmacyID) {
        return dbService.getPharmacyByID(pharmacyID);
    }

    @GetMapping("/getPharmacyList")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<PharmacyDTO> getPharmacyList() {
        return dbService.getPharmacyList();
    }

    @GetMapping("/addPharmacy")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PharmacyDTO addPharmacy(@RequestParam String address, @RequestParam Double rating, @RequestParam String phoneNumber, @RequestParam Long networkID) {
        return dbService.addPharmacy(address, rating, phoneNumber, networkID);
    }

    @PostMapping("/deletePharmacyByID")
    @ResponseStatus(HttpStatus.OK)
    public void deletePharmacyByID(@RequestParam Long pharmacyID) {
        dbService.deletePharmacyByID(pharmacyID);
    }

    @GetMapping("/editPharmacy")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PharmacyDTO editPharmacy(@RequestParam Long pharmacyID, @RequestParam String address, @RequestParam Double rating, @RequestParam String phoneNumber, @RequestParam Long networkID) {
        return dbService.editPharmacy(pharmacyID, address, rating, phoneNumber, networkID);
    }

}
