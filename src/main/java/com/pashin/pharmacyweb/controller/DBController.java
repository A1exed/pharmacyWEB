package com.pashin.pharmacyweb.controller;

import com.pashin.pharmacyweb.service.dbservices.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DBController {

    @Autowired
    private DrugInPharmacyService drugInPharmacyService;

    @Autowired
    private DrugService drugService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private NetworkService networkService;

    @Autowired
    private PharmacyService pharmacyService;
}
