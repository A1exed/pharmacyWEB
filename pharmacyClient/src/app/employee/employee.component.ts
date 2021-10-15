import { Component, OnInit } from '@angular/core';
import {Pharmacy} from "../model/pharmacy";
import {Network} from "../model/network";
import {Employee} from "../model/employee";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employees: Employee[] = [];

  employee: Employee = new Employee(0, '', '', '', new Pharmacy(0, '', 0, '', new Network(0, '', '', '')));

  pharmacies: Pharmacy[] = [];

  constructor() {
    this.getList();
  }

  async getList() {
    const response = await fetch('http://localhost:8080/getEmployeeList');
    const response1 = await fetch('http://localhost:8080/getPharmacyList');
    if (response.ok && response1.ok) {
      this.employees = await response.json();
      console.log(this.employees);
      this.pharmacies = await response1.json();
      console.log(this.pharmacies);
    } else {

    }
  }

  async edit(employee: Employee): Promise<Employee> {
    const response = await fetch('http://localhost:8080/editEmployee?' + 'employeeID=' + employee.employeeID +
      '&employeeName=' + employee.employeeName + '&position=' + employee.position + '&phoneNumber=' + employee.phoneNumber +
      '&pharmacyID=' + employee.pharmacy.pharmacyID);
    if (response.ok) {
      let newEmployee: Employee = await response.json();
      console.log(newEmployee);
      return newEmployee;
    } else {
      return employee;
    }
  }

  async delete(employee: Employee) {
    const response = await fetch('http://localhost:8080/deleteEmployeeByID?' + 'employeeID=' + employee.employeeID);
    if (response.ok) {
      this.employees.splice(this.employees.indexOf(employee), 1);
    } else {

    }
  }

  async add(employee: Employee) {
    const response = await fetch('http://localhost:8080/addEmployee?' + 'employeeName=' + employee.employeeName +
        '&position=' + employee.position + '&phoneNumber=' + employee.phoneNumber +'&pharmacyID=' + employee.pharmacy.pharmacyID);
    if (response.ok) {
      this.employee = await response.json();
      console.log(this.employee);
      this.employees.push(this.employee);
      this.employee = new Employee(0, '', '', '', new Pharmacy(0, '', 0, '', new Network(0, '', '', '')));
    } else {

    }
  }

  ngOnInit(): void {
  }

}
