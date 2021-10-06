package com.pashin.pharmacyweb.service.db;

import com.pashin.pharmacyweb.model.DrugInPharmacyModel;
import com.pashin.pharmacyweb.repository.DrugInPharmacyRepository;
import com.pashin.pharmacyweb.service.IDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugInPharmacyService implements IDBService<DrugInPharmacyModel, DrugInPharmacyModel.DrugInPharmacyKey> {

    @Autowired
    private DrugInPharmacyRepository drugInPharmacyRepository;


    @Override
    public DrugInPharmacyModel add(DrugInPharmacyModel element) {
        return drugInPharmacyRepository.saveAndFlush(element);
    }

    @Override
    public void deleteByID(DrugInPharmacyModel.DrugInPharmacyKey drugInPharmacyKey) {
        drugInPharmacyRepository.deleteById(drugInPharmacyKey);
    }

    @Override
    public DrugInPharmacyModel editElement(DrugInPharmacyModel element) {
        return drugInPharmacyRepository.saveAndFlush(element);
    }

    @Override
    public DrugInPharmacyModel getByID(DrugInPharmacyModel.DrugInPharmacyKey drugInPharmacyKey) {
        return drugInPharmacyRepository.getById(drugInPharmacyKey);
    }

    @Override
    public List<DrugInPharmacyModel> getAll() {
        return drugInPharmacyRepository.findAll();
    }
}
