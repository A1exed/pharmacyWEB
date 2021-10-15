package com.pashin.pharmacyweb.service;

import com.pashin.pharmacyweb.dto.*;
import com.pashin.pharmacyweb.model.*;
import com.pashin.pharmacyweb.service.db.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DBService {

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

    public DrugInPharmacyDTO getDrugInPharmacyByID(Long drugID, Long pharmacyID) {
        DrugInPharmacyModel model = drugInPharmacyService.getByID(new DrugInPharmacyModel.DrugInPharmacyKey(pharmacyID, drugID));
        PharmacyModel pharmacyModel = model.getPharmacyID();
        NetworkModel networkModel = pharmacyModel.getNetworkID();
        DrugModel drugModel = model.getDrugID();
        return new DrugInPharmacyDTO(new PharmacyDTO(pharmacyModel.getPharmacyID(), pharmacyModel.getAddress(), pharmacyModel.getRating(), pharmacyModel.getPhoneNumber(), new NetworkDTO(networkModel.getNetworkID(), networkModel.getNetworkName(), networkModel.getPhoneNumber(), networkModel.getOwner())), new DrugDTO(drugModel.getDrugID(), drugModel.getDrugName(), drugModel.getForm(), drugModel.getManufacturerName()), model.getQuantity());
    }

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
            results.add(new DrugInPharmacyDTO(new PharmacyDTO(pharmacyModel.getPharmacyID(), pharmacyModel.getAddress(), pharmacyModel.getRating(), pharmacyModel.getPhoneNumber(), new NetworkDTO(networkModel.getNetworkID(), networkModel.getNetworkName(), networkModel.getPhoneNumber(), networkModel.getOwner())), new DrugDTO(drugModel.getDrugID(), drugModel.getDrugName(), drugModel.getForm(), drugModel.getManufacturerName()), model.getQuantity()));
        }
        return results;
    }

    public DrugInPharmacyDTO addDrugInPharmacy(Long pharmacyID, Long drugID, Integer quantity) {
        DrugInPharmacyModel model = drugInPharmacyService.add(new DrugInPharmacyModel(pharmacyService.getByID(pharmacyID), drugService.getByID(drugID), quantity));
        PharmacyModel pharmacyModel = model.getPharmacyID();
        NetworkModel networkModel = pharmacyModel.getNetworkID();
        DrugModel drugModel = model.getDrugID();
        return new DrugInPharmacyDTO(new PharmacyDTO(pharmacyModel.getPharmacyID(), pharmacyModel.getAddress(), pharmacyModel.getRating(), pharmacyModel.getPhoneNumber(), new NetworkDTO(networkModel.getNetworkID(), networkModel.getNetworkName(), networkModel.getPhoneNumber(), networkModel.getOwner())), new DrugDTO(drugModel.getDrugID(), drugModel.getDrugName(), drugModel.getForm(), drugModel.getManufacturerName()), model.getQuantity());
    }

    public void deleteDrugInPharmacyByID(Long pharmacyID, Long drugID) {
        drugInPharmacyService.deleteByID(new DrugInPharmacyModel.DrugInPharmacyKey(pharmacyID, drugID));
    }

    public DrugInPharmacyDTO editDrugInPharmacy(Long pharmacyID, Long drugID, Integer quantity) {
        DrugInPharmacyModel model = drugInPharmacyService.getByID(new DrugInPharmacyModel.DrugInPharmacyKey(pharmacyID, drugID));
        model.setQuantity(quantity);
        model = drugInPharmacyService.editElement(model);
        PharmacyModel pharmacyModel = model.getPharmacyID();
        NetworkModel networkModel = pharmacyModel.getNetworkID();
        DrugModel drugModel = model.getDrugID();
        return new DrugInPharmacyDTO(new PharmacyDTO(pharmacyModel.getPharmacyID(), pharmacyModel.getAddress(), pharmacyModel.getRating(), pharmacyModel.getPhoneNumber(), new NetworkDTO(networkModel.getNetworkID(), networkModel.getNetworkName(), networkModel.getPhoneNumber(), networkModel.getOwner())), new DrugDTO(drugModel.getDrugID(), drugModel.getDrugName(), drugModel.getForm(), drugModel.getManufacturerName()), model.getQuantity());
    }

    public DrugDTO getDrugByID(Long drugID) {
        DrugModel model = drugService.getByID(drugID);
        return new DrugDTO(model.getDrugID(), model.getDrugName(), model.getForm(), model.getManufacturerName());
    }

    public List<DrugDTO> getDrugList() {
        List<DrugModel> models = drugService.getAll();
        List<DrugDTO> results = new ArrayList<>();
        for (DrugModel model : models) {
            results.add(new DrugDTO(model.getDrugID(), model.getDrugName(), model.getForm(), model.getManufacturerName()));
        }
        return results;
    }

    public DrugDTO addDrug(String drugName, String form, String manufacturerName) {
        DrugModel model = drugService.add(new DrugModel(drugName, form, manufacturerName));
        return new DrugDTO(model.getDrugID(), model.getDrugName(), model.getForm(), model.getManufacturerName());
    }

    public void deleteDrugByID(Long drugID) {
        drugService.deleteByID(drugID);
    }

    public DrugDTO editDrug(Long drugID, String drugName, String form, String manufacturerName) {
        DrugModel model = drugService.getByID(drugID);
        model.setDrugName(drugName);
        model.setForm(form);
        model.setManufacturerName(manufacturerName);
        model = drugService.editElement(model);
        return new DrugDTO(model.getDrugID(), model.getDrugName(), model.getForm(), model.getManufacturerName());
    }

    public EmployeeDTO getEmployeeByID(Long employeeID) {
        EmployeeModel model = employeeService.getByID(employeeID);
        PharmacyModel pharmacyModel = model.getPharmacyID();
        NetworkModel networkModel = pharmacyModel.getNetworkID();
        return new EmployeeDTO(model.getEmployeeID(), model.getEmployeeName(), model.getPosition(), model.getPhoneNumber(), new PharmacyDTO(pharmacyModel.getPharmacyID(), pharmacyModel.getAddress(), pharmacyModel.getRating(), pharmacyModel.getPhoneNumber(), new NetworkDTO(networkModel.getNetworkID(), networkModel.getNetworkName(), networkModel.getPhoneNumber(), networkModel.getOwner())));
    }

    public List<EmployeeDTO> getEmployeeList() {
        List<EmployeeModel> models = employeeService.getAll();
        List<EmployeeDTO> results = new ArrayList<>();
        PharmacyModel pharmacyModel;
        NetworkModel networkModel;
        for (EmployeeModel model : models) {
            pharmacyModel = model.getPharmacyID();
            networkModel = pharmacyModel.getNetworkID();
            results.add(new EmployeeDTO(model.getEmployeeID(), model.getEmployeeName(), model.getPosition(), model.getPhoneNumber(), new PharmacyDTO(pharmacyModel.getPharmacyID(), pharmacyModel.getAddress(), pharmacyModel.getRating(), pharmacyModel.getPhoneNumber(), new NetworkDTO(networkModel.getNetworkID(), networkModel.getNetworkName(), networkModel.getPhoneNumber(), networkModel.getOwner()))));
        }
        return results;
    }

    public EmployeeDTO addEmployee(String employeeName, String position, String phoneNumber, Long pharmacyID) {
        PharmacyModel pharmacyModel = pharmacyService.getByID(pharmacyID);
        EmployeeModel model = employeeService.add(new EmployeeModel(employeeName, position, phoneNumber, pharmacyModel));
        pharmacyModel = model.getPharmacyID();
        NetworkModel networkModel = pharmacyModel.getNetworkID();
        return new EmployeeDTO(model.getEmployeeID(), model.getEmployeeName(), model.getPosition(), model.getPhoneNumber(), new PharmacyDTO(pharmacyModel.getPharmacyID(), pharmacyModel.getAddress(), pharmacyModel.getRating(), pharmacyModel.getPhoneNumber(), new NetworkDTO(networkModel.getNetworkID(), networkModel.getNetworkName(), networkModel.getPhoneNumber(), networkModel.getOwner())));
    }

    public void deleteEmployeeByID(Long employeeID) {
        employeeService.deleteByID(employeeID);
    }

    public EmployeeDTO editEmployee(Long employeeID, String employeeName, String position, String phoneNumber, Long pharmacyID) {
        EmployeeModel model = employeeService.getByID(employeeID);
        model.setEmployeeName(employeeName);
        model.setPosition(position);
        model.setPhoneNumber(phoneNumber);
        model.setPharmacyID(pharmacyService.getByID(pharmacyID));
        model = employeeService.editElement(model);
        PharmacyModel pharmacyModel = model.getPharmacyID();
        NetworkModel networkModel = pharmacyModel.getNetworkID();
        return new EmployeeDTO(model.getEmployeeID(), model.getEmployeeName(), model.getPosition(), model.getPhoneNumber(), new PharmacyDTO(pharmacyModel.getPharmacyID(), pharmacyModel.getAddress(), pharmacyModel.getRating(), pharmacyModel.getPhoneNumber(), new NetworkDTO(networkModel.getNetworkID(), networkModel.getNetworkName(), networkModel.getPhoneNumber(), networkModel.getOwner())));
    }

    public NetworkDTO getNetworkByID(Long networkID) {
        NetworkModel model = networkService.getByID(networkID);
        return new NetworkDTO(model.getNetworkID(), model.getNetworkName(), model.getPhoneNumber(), model.getOwner());
    }

    public List<NetworkDTO> getNetworkList() {
        List<NetworkModel> models = networkService.getAll();
        List<NetworkDTO> results = new ArrayList<>();
        for (NetworkModel model : models) {
            results.add(new NetworkDTO(model.getNetworkID(), model.getNetworkName(), model.getPhoneNumber(), model.getOwner()));
        }
        return results;
    }

    public NetworkDTO addNetwork(String networkName, String phoneNumber, String owner) {
        NetworkModel model = networkService.add(new NetworkModel(networkName, phoneNumber, owner));
        return new NetworkDTO(model.getNetworkID(), model.getNetworkName(), model.getPhoneNumber(), model.getOwner());
    }

    public void deleteNetworkByID(Long networkID) {
        networkService.deleteByID(networkID);
    }

    public NetworkDTO editNetwork(Long networkID, String networkName, String phoneNumber, String owner) {
        NetworkModel model = networkService.getByID(networkID);
        model.setNetworkName(networkName);
        model.setPhoneNumber(phoneNumber);
        model.setOwner(owner);
        model = networkService.editElement(model);
        return new NetworkDTO(model.getNetworkID(), model.getNetworkName(), model.getPhoneNumber(), model.getOwner());
    }

    public PharmacyDTO getPharmacyByID(Long pharmacyID) {
        PharmacyModel model = pharmacyService.getByID(pharmacyID);
        NetworkModel networkModel = model.getNetworkID();
        return new PharmacyDTO(model.getPharmacyID(), model.getAddress(), model.getRating(), model.getPhoneNumber(), new NetworkDTO(networkModel.getNetworkID(), networkModel.getNetworkName(), networkModel.getPhoneNumber(), networkModel.getOwner()));
    }

    public List<PharmacyDTO> getPharmacyList() {
        List<PharmacyModel> models = pharmacyService.getAll();
        List<PharmacyDTO> results = new ArrayList<>();
        NetworkModel networkModel;
        for (PharmacyModel model : models) {
            networkModel = model.getNetworkID();
            results.add(new PharmacyDTO(model.getPharmacyID(), model.getAddress(), model.getRating(), model.getPhoneNumber(), new NetworkDTO(networkModel.getNetworkID(), networkModel.getNetworkName(), networkModel.getPhoneNumber(), networkModel.getOwner())));
        }
        return results;
    }

    public PharmacyDTO addPharmacy(String address, Double rating, String phoneNumber, Long networkID) {
        NetworkModel networkModel = networkService.getByID(networkID);
        PharmacyModel model = pharmacyService.add(new PharmacyModel(address, rating, phoneNumber, networkModel));
        networkModel = model.getNetworkID();
        return new PharmacyDTO(model.getPharmacyID(), model.getAddress(), model.getRating(), model.getPhoneNumber(), new NetworkDTO(networkModel.getNetworkID(), networkModel.getNetworkName(), networkModel.getPhoneNumber(), networkModel.getOwner()));
    }

    public void deletePharmacyByID(Long pharmacyID) {
        pharmacyService.deleteByID(pharmacyID);
    }

    public PharmacyDTO editPharmacy(Long pharmacyID, String address, Double rating, String phoneNumber, Long networkID) {
        PharmacyModel model = pharmacyService.getByID(pharmacyID);
        model.setAddress(address);
        model.setRating(rating);
        model.setPhoneNumber(phoneNumber);
        model.setNetworkID(networkService.getByID(networkID));
        model = pharmacyService.editElement(model);
        NetworkModel networkModel = model.getNetworkID();
        return new PharmacyDTO(model.getPharmacyID(), model.getAddress(), model.getRating(), model.getPhoneNumber(), new NetworkDTO(networkModel.getNetworkID(), networkModel.getNetworkName(), networkModel.getPhoneNumber(), networkModel.getOwner()));
    }
}
