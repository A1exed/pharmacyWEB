package com.pashin.pharmacyweb.service.dbservices;

import com.pashin.pharmacyweb.model.DrugInPharmacyModel;
import com.pashin.pharmacyweb.repository.DrugInPharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugInPharmacyService {

    @Autowired
    private DrugInPharmacyRepository drugInPharmacyRepository;

    public DrugInPharmacyModel add(DrugInPharmacyModel element) {
        return drugInPharmacyRepository.saveAndFlush(element);
    }

    public void deleteByID(DrugInPharmacyModel.DrugInPharmacyKey ID) {
        drugInPharmacyRepository.deleteById(ID);
    }

    public DrugInPharmacyModel editElement(DrugInPharmacyModel element) {
        return drugInPharmacyRepository.saveAndFlush(element);
    }

    public DrugInPharmacyModel getByID(DrugInPharmacyModel.DrugInPharmacyKey ID) {
        return drugInPharmacyRepository.getById(ID);
    }

    public List<DrugInPharmacyModel> getAll() {
        return drugInPharmacyRepository.findAll();
    }
}
