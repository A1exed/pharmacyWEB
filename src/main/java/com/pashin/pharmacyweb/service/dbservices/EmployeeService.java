package com.pashin.pharmacyweb.service.dbservices;

import com.pashin.pharmacyweb.model.EmployeeModel;
import com.pashin.pharmacyweb.repository.EmployeeRepository;
import com.pashin.pharmacyweb.service.IDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IDBService<EmployeeModel> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeModel add(EmployeeModel element) {
        return employeeRepository.saveAndFlush(element);
    }

    @Override
    public void deleteByID(long ID) {
        employeeRepository.deleteById(ID);
    }

    @Override
    public EmployeeModel editElement(EmployeeModel element) {
        return employeeRepository.saveAndFlush(element);
    }

    @Override
    public EmployeeModel getByID(long ID) {
        return employeeRepository.getById(ID);
    }

    @Override
    public List<EmployeeModel> getAll() {
        return employeeRepository.findAll();
    }
}
