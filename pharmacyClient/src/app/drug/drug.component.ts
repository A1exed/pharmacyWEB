import {Component, OnInit} from '@angular/core';
import {Drug} from "../model/drug";
import {AppService} from "../app.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-drug',
  templateUrl: './drug.component.html',
  styleUrls: ['./drug.component.css']
})
export class DrugComponent implements OnInit {

  drugs: Drug[] = [];

  drug: Drug = new Drug(0, '', '', '');

  constructor(public app: AppService, public router: Router) {
    if (!app.authenticated) {
      router.navigateByUrl('');
    } else {
      this.getList();
    }
  }

  async getList() {
    const response = await fetch(this.app.serverURL + this.app.role + '/getDrugList', {
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
        this.drugs = await response.json();
      } else {
        alert('Сервис недоступен');
      }
    }
  }

  async edit(drug: Drug): Promise<Drug> {
    const response = await fetch(this.app.serverURL + this.app.role + '/editDrug?' + 'drugID=' + drug.drugID +
        '&drugName=' + drug.drugName + '&form=' + drug.form + '&manufacturerName=' + drug.manufacturerName, {
      method: 'GET',
      headers: new Headers({
        'Authorization': 'Bearer ' + this.app.user.token,
        'Content-Type': 'application/json;charset=utf-8'
      })
    });
    if (response.status === 401) {
      await this.router.navigateByUrl('');
      return drug;
    } else {
      if (response.ok) {
        return await response.json();
      } else {
        alert('Сервис недоступен');
        return drug;
      }
    }
  }

  async delete(drug: Drug) {
    const response = await fetch(this.app.serverURL + this.app.role + '/deleteDrugByID?' + 'drugID=' + drug.drugID, {
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
        this.drugs.splice(this.drugs.indexOf(drug), 1);
      } else {
        alert('Сервис недоступен');
      }
    }
  }

  async add(drug: Drug) {
    const response = await fetch(this.app.serverURL + this.app.role + '/addDrug?' + 'drugName=' + drug.drugName +
        '&form=' + drug.form + '&manufacturerName=' + drug.manufacturerName, {
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
        this.drug = await response.json();
        this.drugs.push(this.drug);
        this.drug = new Drug(0, '', '', '');
      } else {
        alert('Сервис недоступен');
      }
    }
  }

  ngOnInit(): void {
  }

}
