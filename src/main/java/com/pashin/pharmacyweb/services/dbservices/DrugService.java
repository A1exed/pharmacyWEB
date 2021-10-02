package com.pashin.pharmacyweb.services.dbservices;

import com.pashin.pharmacyweb.entities.DrugEntity;
import com.pashin.pharmacyweb.repositories.DrugRepository;
import com.pashin.pharmacyweb.services.IDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugService implements IDBService<DrugEntity> {

    @Autowired
    private DrugRepository drugRepository;

    @Override
    public DrugEntity add(DrugEntity element) {
        return drugRepository.saveAndFlush(element);
    }

    @Override
    public void deleteByID(long ID) {
        drugRepository.deleteById(ID);
    }

    @Override
    public DrugEntity editElement(DrugEntity element) {
        return drugRepository.saveAndFlush(element);
    }

    @Override
    public DrugEntity getByID(long ID) {
        return drugRepository.getById(ID);
    }

    @Override
    public List<DrugEntity> getAll() {
        return drugRepository.findAll();
    }
}
