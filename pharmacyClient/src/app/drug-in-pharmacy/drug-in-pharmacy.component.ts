import {Component, OnInit} from '@angular/core';
import {Pharmacy} from "../model/pharmacy";
import {Network} from "../model/network";
import {DrugInPharmacy} from "../model/drug-in-pharmacy";
import {Drug} from "../model/drug";
import {AppService} from "../app.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-drug-in-pharmacy',
  templateUrl: './drug-in-pharmacy.component.html',
  styleUrls: ['./drug-in-pharmacy.component.css']
})
export class DrugInPharmacyComponent implements OnInit {

  drugsInPharmacies: DrugInPharmacy[] = [];

  drugInPharmacy: DrugInPharmacy = new DrugInPharmacy(new Pharmacy(0, '', 0, '', new Network(0, '', '', '')), new Drug(0, '', '', ''), 0);

  pharmacies: Pharmacy[] = [];

  drugs: Drug[] = [];

  constructor(public app: AppService, public router: Router) {
    if (!app.authenticated) {
      router.navigateByUrl('');
    } else {
      this.getList();
    }
  }

  async getList() {
    const response = await fetch(this.app.serverURL + this.app.role + '/getDrugInPharmacyList', {
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
    const response2 = await fetch(this.app.serverURL + this.app.role + '/getDrugList', {
      method: 'GET',
      headers: new Headers({
        'Authorization': 'Bearer ' + this.app.user.token,
        'Content-Type': 'application/json;charset=utf-8'
      })
    });
    if (response.status === 401 || response1.status === 401 || response2.status === 401) {
      await this.router.navigateByUrl('');
    } else {
      if (response.ok && response1.ok && response2.ok) {
        this.drugsInPharmacies = await response.json();
        this.pharmacies = await response1.json();
        this.drugs = await response2.json();
      } else {
        alert('Сервис недоступен');
      }
    }
  }

  async edit(drugInPharmacy: DrugInPharmacy): Promise<DrugInPharmacy> {
    const response = await fetch(this.app.serverURL + this.app.role + '/editDrugInPharmacy?' + 'pharmacyID=' + drugInPharmacy.pharmacy.pharmacyID +
        '&drugID=' + drugInPharmacy.drug.drugID + '&quantity=' + drugInPharmacy.quantity, {
      method: 'GET',
      headers: new Headers({
        'Authorization': 'Bearer ' + this.app.user.token,
        'Content-Type': 'application/json;charset=utf-8'
      })
    });
    if (response.status === 401) {
      await this.router.navigateByUrl('');
      return drugInPharmacy;
    } else {
      if (response.ok) {
        return await response.json();
      } else {
        alert('Сервис недоступен');
        return drugInPharmacy;
      }
    }
  }

  async delete(drugInPharmacy: DrugInPharmacy) {
    const response = await fetch(this.app.serverURL + this.app.role + '/deleteDrugInPharmacyByID?' + 'pharmacyID=' + drugInPharmacy.pharmacy.pharmacyID +
        '&drugID=' + drugInPharmacy.drug.drugID, {
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
        this.drugsInPharmacies.splice(this.drugsInPharmacies.indexOf(drugInPharmacy), 1);
      } else {
        alert('Сервис недоступен');
      }
    }
  }

  async add(drugInPharmacy: DrugInPharmacy) {
    const response = await fetch(this.app.serverURL + this.app.role + '/addDrugInPharmacy?' + 'pharmacyID=' + drugInPharmacy.pharmacy.pharmacyID +
        '&drugID=' + drugInPharmacy.drug.drugID + '&quantity=' + drugInPharmacy.quantity, {
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
        this.drugInPharmacy = await response.json();
        this.drugsInPharmacies.push(this.drugInPharmacy);
        this.drugInPharmacy = new DrugInPharmacy(new Pharmacy(0, '', 0, '', new Network(0, '', '', '')), new Drug(0, '', '', ''), 0);
      } else {
        alert('Сервис недоступен');
      }
    }
  }

  ngOnInit(): void {
  }

}
