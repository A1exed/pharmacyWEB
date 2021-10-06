package com.pashin.pharmacyweb.controller;

import com.pashin.pharmacyweb.dto.DrugInPharmacyDTO;
import com.pashin.pharmacyweb.model.*;
import com.pashin.pharmacyweb.service.db.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
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
    public DrugInPharmacyDTO getDrugInPharmacyByID(@RequestParam Long drugID, @RequestParam Long pharmacyID) {
        DrugInPharmacyModel model = drugInPharmacyService.getByID(new DrugInPharmacyModel.DrugInPharmacyKey(pharmacyID, drugID));
        PharmacyModel pharmacyModel = model.getPharmacyID();
        NetworkModel networkModel = pharmacyModel.getNetworkID();
        DrugModel drugModel = model.getDrugID();
        return new DrugInPharmacyDTO(pharmacyModel.getPharmacyID(), drugModel.getDrugID(), networkModel.getNetworkName(), pharmacyModel.getAddress(), drugModel.getDrugName(), drugModel.getForm(), drugModel.getManufacturerName(), model.getQuantity());
    }

    @GetMapping("/getDrugInPharmacyList")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<DrugInPharmacyDTO> getDrugInPharmacyList() {
        List<DrugInPharmacyModel> models = drugInPharmacyService.getAll();
        List<DrugInPharmacyDTO> results = new ArrayList<>();
        PharmacyModel pharmacyModel;
        NetworkModel networkModel;
        DrugModel drugModel;
        for (DrugInPharmacyModel model : models) {
            pharmacyModel = model.getPharmacyID();
            networkModel = pharmacyModel.getNetworkID();
            drugModel = model.getDrugID();
            results.add(new DrugInPharmacyDTO(pharmacyModel.getPharmacyID(), drugModel.getDrugID(), networkModel.getNetworkName(), pharmacyModel.getAddress(), drugModel.getDrugName(), drugModel.getForm(), drugModel.getManufacturerName(), model.getQuantity()));
        }
        return results;
    }

    @GetMapping("/addDrugInPharmacy")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DrugInPharmacyDTO addDrugInPharmacy(@RequestParam Long pharmacyID, @RequestParam Long drugID, @RequestParam Integer quantity) {
        DrugInPharmacyModel model = drugInPharmacyService.add(new DrugInPharmacyModel(pharmacyService.getByID(pharmacyID), drugService.getByID(drugID), quantity));
        PharmacyModel pharmacyModel = model.getPharmacyID();
        NetworkModel networkModel = pharmacyModel.getNetworkID();
        DrugModel drugModel = model.getDrugID();
        return new DrugInPharmacyDTO(pharmacyModel.getPharmacyID(), drugModel.getDrugID(), networkModel.getNetworkName(), pharmacyModel.getAddress(), drugModel.getDrugName(), drugModel.getForm(), drugModel.getManufacturerName(), model.getQuantity());
    }

    @PostMapping("/deleteDrugInPharmacyByID")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDrugInPharmacyByID(@RequestParam Long pharmacyID, @RequestParam Long drugID) {
        drugInPharmacyService.deleteByID(new DrugInPharmacyModel.DrugInPharmacyKey(pharmacyID, drugID));
    }

    @GetMapping("/editDrugInPharmacy")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DrugInPharmacyDTO editDrugInPharmacy(@RequestParam Long pharmacyID, @RequestParam Long drugID, @RequestParam Integer quantity) {
        DrugInPharmacyModel model = drugInPharmacyService.getByID(new DrugInPharmacyModel.DrugInPharmacyKey(pharmacyID, drugID));
        model.setQuantity(quantity);
        model = drugInPharmacyService.editElement(model);
        PharmacyModel pharmacyModel = model.getPharmacyID();
        NetworkModel networkModel = pharmacyModel.getNetworkID();
        DrugModel drugModel = model.getDrugID();
        return new DrugInPharmacyDTO(pharmacyModel.getPharmacyID(), drugModel.getDrugID(), networkModel.getNetworkName(), pharmacyModel.getAddress(), drugModel.getDrugName(), drugModel.getForm(), drugModel.getManufacturerName(), model.getQuantity());
    }
//TODO: Доделать
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
    @Transactional
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
