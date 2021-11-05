import {Component, OnInit} from '@angular/core';
import {Pharmacy} from "../model/pharmacy";
import {Network} from "../model/network";
import {Employee} from "../model/employee";
import {AppService} from "../app.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employees: Employee[] = [];

  employee: Employee = new Employee(0, '', '', '', new Pharmacy(0, '', 0, '', new Network(0, '', '', '')));

  pharmacies: Pharmacy[] = [];

  constructor(public app: AppService, public router: Router) {
    if (!app.authenticated) {
      router.navigateByUrl('');
    } else {
      this.getList();
    }
  }

  async getList() {
    const response = await fetch(this.app.serverURL + this.app.role + '/getEmployeeList', {
      method: 'GET',
      headers: new Headers({
        'Authorization': 'Bearer ' + this.app.user.token,
        'Content-Type': 'application/json;charset=utf-8'
      })
    });
    const response1 = await fetch(this.app.serverURL + this.app.role + '/getPharmacyList', {
      method: 'GET',
      headers: new Headers({
        'Authorization': 'Bearer ' + this.app.user.token,
        'Content-Type': 'application/json;charset=utf-8'
      })
    });
    if (response.status === 401 || response1.status === 401) {
      await this.router.navigateByUrl('');
    } else {
      if (response.ok && response1.ok) {
        this.employees = await response.json();
        this.pharmacies = await response1.json();
      } else {
        alert('Сервис недоступен');
      }
    }
  }

  async edit(employee: Employee): Promise<Employee> {
    const response = await fetch(this.app.serverURL + this.app.role + '/editEmployee?' + 'employeeID=' + employee.employeeID +
      '&employeeName=' + employee.employeeName + '&position=' + employee.position + '&phoneNumber=' + employee.phoneNumber +
      '&pharmacyID=' + employee.pharmacy.pharmacyID, {
      method: 'GET',
      headers: new Headers({
        'Authorization': 'Bearer ' + this.app.user.token,
        'Content-Type': 'application/json;charset=utf-8'
      })
    });
    if (response.status === 401) {
      await this.router.navigateByUrl('');
      return employee;
    } else {
      if (response.ok) {
        return await response.json();
      } else {
        alert('Сервис недоступен');
        return employee;
      }
    }
  }

  async delete(employee: Employee) {
    const response = await fetch(this.app.serverURL + this.app.role + '/deleteEmployeeByID?' + 'employeeID=' + employee.employeeID, {
      method: 'GET',
      headers: new Headers({
        'Authorization': 'Bearer ' + this.app.user.token,
        'Content-Type': 'application/json;charset=utf-8'
      })
    });
    if (response.status === 401) {
      await this.router.navigateByUrl('');
    } else {
      if (response.ok) {
        this.employees.splice(this.employees.indexOf(employee), 1);
      } else {
        alert('Сервис недоступен');
      }
    }
  }

  async add(employee: Employee) {
    const response = await fetch(this.app.serverURL + this.app.role + '/addEmployee?' + 'employeeName=' + employee.employeeName +
        '&position=' + employee.position + '&phoneNumber=' + employee.phoneNumber +'&pharmacyID=' + employee.pharmacy.pharmacyID, {
      method: 'GET',
      headers: new Headers({
        'Authorization': 'Bearer ' + this.app.user.token,
        'Content-Type': 'application/json;charset=utf-8'
      })
    });
    if (response.status === 401) {
      await this.router.navigateByUrl('');
    } else {
      if (response.ok) {
        this.employee = await response.json();
        this.employees.push(this.employee);
        this.employee = new Employee(0, '', '', '', new Pharmacy(0, '', 0, '', new Network(0, '', '', '')));
      } else {
        alert('Сервис недоступен');
      }
    }
  }

  ngOnInit(): void {
  }

}
