package com.pashin.pharmacyweb.services.dbservices;

import com.pashin.pharmacyweb.entities.EmployeeEntity;
import com.pashin.pharmacyweb.repositories.EmployeeRepository;
import com.pashin.pharmacyweb.services.IDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IDBService<EmployeeEntity> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeEntity add(EmployeeEntity element) {
        return employeeRepository.saveAndFlush(element);
    }

    @Override
    public void deleteByID(long ID) {
        employeeRepository.deleteById(ID);
    }

    @Override
    public EmployeeEntity editElement(EmployeeEntity element) {
        return employeeRepository.saveAndFlush(element);
    }

    @Override
    public EmployeeEntity getByID(long ID) {
        return employeeRepository.getById(ID);
    }

    @Override
    public List<EmployeeEntity> getAll() {
        return employeeRepository.findAll();
    }
}
