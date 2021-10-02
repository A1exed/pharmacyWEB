package com.pashin.pharmacyweb.service.db;

import com.pashin.pharmacyweb.model.DrugModel;
import com.pashin.pharmacyweb.repository.DrugRepository;
import com.pashin.pharmacyweb.service.IDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugService implements IDBService<DrugModel> {

    @Autowired
    private DrugRepository drugRepository;

    @Override
    public DrugModel add(DrugModel element) {
        return drugRepository.saveAndFlush(element);
    }

    @Override
    public void deleteByID(long ID) {
        drugRepository.deleteById(ID);
    }

    @Override
    public DrugModel editElement(DrugModel element) {
        return drugRepository.saveAndFlush(element);
    }

    @Override
    public DrugModel getByID(long ID) {
        return drugRepository.getById(ID);
    }

    @Override
    public List<DrugModel> getAll() {
        return drugRepository.findAll();
    }
}
