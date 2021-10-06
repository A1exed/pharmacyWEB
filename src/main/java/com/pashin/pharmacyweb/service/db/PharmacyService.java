package com.pashin.pharmacyweb.service.db;

import com.pashin.pharmacyweb.model.PharmacyModel;
import com.pashin.pharmacyweb.repository.PharmacyRepository;
import com.pashin.pharmacyweb.service.IDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyService implements IDBService<PharmacyModel, Long> {

    @Autowired
    private PharmacyRepository pharmacyRepository;

    @Override
    public PharmacyModel add(PharmacyModel element) {
        return pharmacyRepository.saveAndFlush(element);
    }

    @Override
    public void deleteByID(Long id) {
        pharmacyRepository.deleteById(id);
    }

    @Override
    public PharmacyModel editElement(PharmacyModel element) {
        return pharmacyRepository.saveAndFlush(element);
    }

    @Override
    public PharmacyModel getByID(Long id) {
        return pharmacyRepository.getById(id);
    }

    @Override
    public List<PharmacyModel> getAll() {
        return pharmacyRepository.findAll();
    }
}
