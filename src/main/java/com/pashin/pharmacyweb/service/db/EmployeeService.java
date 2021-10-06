package com.pashin.pharmacyweb.service.db;

import com.pashin.pharmacyweb.model.EmployeeModel;
import com.pashin.pharmacyweb.repository.EmployeeRepository;
import com.pashin.pharmacyweb.service.IDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IDBService<EmployeeModel, Long> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeModel add(EmployeeModel element) {
        return employeeRepository.saveAndFlush(element);
    }

    @Override
    public void deleteByID(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeModel editElement(EmployeeModel element) {
        return employeeRepository.saveAndFlush(element);
    }

    @Override
    public EmployeeModel getByID(Long id) {
        return employeeRepository.getById(id);
    }

    @Override
    public List<EmployeeModel> getAll() {
        return employeeRepository.findAll();
    }
}
