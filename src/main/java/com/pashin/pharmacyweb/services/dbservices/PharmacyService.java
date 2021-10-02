package com.pashin.pharmacyweb.services.dbservices;

import com.pashin.pharmacyweb.entities.PharmacyEntity;
import com.pashin.pharmacyweb.repositories.PharmacyRepository;
import com.pashin.pharmacyweb.services.IDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyService implements IDBService<PharmacyEntity> {

    @Autowired
    private PharmacyRepository pharmacyRepository;

    @Override
    public PharmacyEntity add(PharmacyEntity element) {
        return pharmacyRepository.saveAndFlush(element);
    }

    @Override
    public void deleteByID(long ID) {
        pharmacyRepository.deleteById(ID);
    }

    @Override
    public PharmacyEntity editElement(PharmacyEntity element) {
        return pharmacyRepository.saveAndFlush(element);
    }

    @Override
    public PharmacyEntity getByID(long ID) {
        return pharmacyRepository.getById(ID);
    }

    @Override
    public List<PharmacyEntity> getAll() {
        return pharmacyRepository.findAll();
    }
}
