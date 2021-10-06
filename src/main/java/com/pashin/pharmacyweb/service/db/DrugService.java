package com.pashin.pharmacyweb.service.db;

import com.pashin.pharmacyweb.model.DrugModel;
import com.pashin.pharmacyweb.repository.DrugRepository;
import com.pashin.pharmacyweb.service.IDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugService implements IDBService<DrugModel, Long> {

    @Autowired
    private DrugRepository drugRepository;

    @Override
    public DrugModel add(DrugModel element) {
        return drugRepository.saveAndFlush(element);
    }

    @Override
    public void deleteByID(Long id) {
        drugRepository.deleteById(id);
    }

    @Override
    public DrugModel editElement(DrugModel element) {
        return drugRepository.saveAndFlush(element);
    }

    @Override
    public DrugModel getByID(Long id) {
        return drugRepository.getById(id);
    }

    @Override
    public List<DrugModel> getAll() {
        return drugRepository.findAll();
    }
}
