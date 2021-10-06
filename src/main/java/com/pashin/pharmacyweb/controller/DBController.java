package com.pashin.pharmacyweb.controller;

import com.pashin.pharmacyweb.model.*;
import com.pashin.pharmacyweb.service.db.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DBController {

    @Autowired
    private DrugInPharmacyService drugInPharmacyService;

    @Autowired
    private DrugService drugService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private NetworkService networkService;

    @Autowired
    private PharmacyService pharmacyService;

    @GetMapping("/getDrugInPharmacyByID")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DrugInPharmacyModel getDrugInPharmacyByID(@RequestBody DrugInPharmacyModel.DrugInPharmacyKey drugInPharmacyID) {
        return drugInPharmacyService.getByID(drugInPharmacyID);
    }

    @GetMapping("/getDrugInPharmacyList")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<DrugInPharmacyModel> getDrugInPharmacyList() {
        return drugInPharmacyService.getAll();
    }

    @GetMapping("/addDrugInPharmacy")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DrugInPharmacyModel addDrugInPharmacy(@RequestBody DrugInPharmacyModel drugInPharmacy) {
        return drugInPharmacyService.add(drugInPharmacy);
    }

    @PostMapping("/deleteDrugInPharmacyByID")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDrugInPharmacyByID(@RequestBody DrugInPharmacyModel.DrugInPharmacyKey drugInPharmacyID) {
        drugInPharmacyService.deleteByID(drugInPharmacyID);
    }

    @GetMapping("/editDrugInPharmacy")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DrugInPharmacyModel editDrugInPharmacy(@RequestBody DrugInPharmacyModel drugInPharmacy) {
        return drugInPharmacyService.editElement(drugInPharmacy);
    }

    @GetMapping("/getDrugByID")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DrugModel getDrugByID(@RequestParam Long drugID) {
        return drugService.getByID(drugID);
    }

    @GetMapping("/getDrugList")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<DrugModel> getDrugList() {
        return drugService.getAll();
    }

    @GetMapping("/addDrug")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DrugModel addDrug(@RequestBody DrugModel drug) {
        return drugService.add(drug);
    }

    @PostMapping("/deleteDrugByID")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDrugByID(@RequestParam Long drugID) {
        drugService.deleteByID(drugID);
    }

    @GetMapping("/editDrug")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DrugModel editDrug(@RequestBody DrugModel drug) {
        return drugService.editElement(drug);
    }

    @GetMapping("/getEmployeeByID")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public EmployeeModel getEmployeeByID(@RequestParam Long employeeID) {
        return employeeService.getByID(employeeID);
    }

    @GetMapping("/getEmployeeList")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<EmployeeModel> getEmployeeList() {
        return employeeService.getAll();
    }

    @GetMapping("/addEmployee")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public EmployeeModel addEmployee(@RequestBody EmployeeModel employee) {
        return employeeService.add(employee);
    }

    @PostMapping("/deleteEmployeeByID")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployeeByID(@RequestParam Long employeeID) {
        employeeService.deleteByID(employeeID);
    }

    @GetMapping("/editEmployee")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public EmployeeModel editEmployee(@RequestBody EmployeeModel employee) {
        return employeeService.editElement(employee);
    }

    @GetMapping("/getNetworkByID")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public NetworkModel getNetworkByID(@RequestParam Long networkID) {
        return networkService.getByID(networkID);
    }

    @GetMapping("/getNetworkList")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<NetworkModel> getNetworkList() {
        return networkService.getAll();
    }

    @GetMapping("/addNetwork")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public NetworkModel addNetwork(@RequestBody NetworkModel network) {
        return networkService.add(network);
    }

    @PostMapping("/deleteNetworkByID")
    @ResponseStatus(HttpStatus.OK)
    public void deleteNetworkByID(@RequestParam Long networkID) {
        networkService.deleteByID(networkID);
    }

    @GetMapping("/editNetwork")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public NetworkModel editNetwork(@RequestBody NetworkModel network) {
        return networkService.editElement(network);
    }

    @GetMapping("/getPharmacyByID")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PharmacyModel getPharmacyByID(@RequestParam Long pharmacyID) {
        return pharmacyService.getByID(pharmacyID);
    }

    @GetMapping("/getPharmacyList")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<PharmacyModel> getPharmacyList() {
        return pharmacyService.getAll();
    }

    @GetMapping("/addPharmacy")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PharmacyModel addPharmacy(@RequestBody PharmacyModel pharmacy) {
        return pharmacyService.add(pharmacy);
    }

    @PostMapping("/deletePharmacyByID")
    @ResponseStatus(HttpStatus.OK)
    public void deletePharmacyByID(@RequestParam Long pharmacyID) {
        pharmacyService.deleteByID(pharmacyID);
    }

    @GetMapping("/editPharmacy")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PharmacyModel editPharmacy(@RequestBody PharmacyModel pharmacy) {
        return pharmacyService.editElement(pharmacy);
    }

}
