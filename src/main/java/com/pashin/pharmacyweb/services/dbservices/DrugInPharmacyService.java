package com.pashin.pharmacyweb.services.dbservices;

import com.pashin.pharmacyweb.entities.DrugInPharmacyEntity;
import com.pashin.pharmacyweb.repositories.DrugInPharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugInPharmacyService {

    @Autowired
    private DrugInPharmacyRepository drugInPharmacyRepository;

    public DrugInPharmacyEntity add(DrugInPharmacyEntity element) {
        return drugInPharmacyRepository.saveAndFlush(element);
    }

    public void deleteByID(DrugInPharmacyEntity.DrugInPharmacyKey ID) {
        drugInPharmacyRepository.deleteById(ID);
    }

    public DrugInPharmacyEntity editElement(DrugInPharmacyEntity element) {
        return drugInPharmacyRepository.saveAndFlush(element);
    }

    public DrugInPharmacyEntity getByID(DrugInPharmacyEntity.DrugInPharmacyKey ID) {
        return drugInPharmacyRepository.getById(ID);
    }

    public List<DrugInPharmacyEntity> getAll() {
        return drugInPharmacyRepository.findAll();
    }
}
