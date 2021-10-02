package com.pashin.pharmacyweb.service.dbservices;

import com.pashin.pharmacyweb.model.PharmacyModel;
import com.pashin.pharmacyweb.repository.PharmacyRepository;
import com.pashin.pharmacyweb.service.IDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyService implements IDBService<PharmacyModel> {

    @Autowired
    private PharmacyRepository pharmacyRepository;

    @Override
    public PharmacyModel add(PharmacyModel element) {
        return pharmacyRepository.saveAndFlush(element);
    }

    @Override
    public void deleteByID(long ID) {
        pharmacyRepository.deleteById(ID);
    }

    @Override
    public PharmacyModel editElement(PharmacyModel element) {
        return pharmacyRepository.saveAndFlush(element);
    }

    @Override
    public PharmacyModel getByID(long ID) {
        return pharmacyRepository.getById(ID);
    }

    @Override
    public List<PharmacyModel> getAll() {
        return pharmacyRepository.findAll();
    }
}
