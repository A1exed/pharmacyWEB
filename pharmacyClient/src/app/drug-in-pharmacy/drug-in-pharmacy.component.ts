import { Component, OnInit } from '@angular/core';
import {Pharmacy} from "../model/pharmacy";
import {Network} from "../model/network";
import {DrugInPharmacy} from "../model/drug-in-pharmacy";
import {Drug} from "../model/drug";

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

  constructor() {
    this.getList();
  }

  async getList() {
    const response = await fetch('http://localhost:8080/getDrugInPharmacyList');
    const response1 = await fetch('http://localhost:8080/getPharmacyList');
    const response2 = await fetch('http://localhost:8080/getDrugList');
    if (response.ok && response1.ok && response2.ok) {
      this.drugsInPharmacies = await response.json();
      console.log(this.drugsInPharmacies);
      this.pharmacies = await response1.json();
      console.log(this.pharmacies);
      this.drugs = await response2.json();
      console.log(this.drugs);
    } else {

    }
  }

  async edit(drugInPharmacy: DrugInPharmacy): Promise<DrugInPharmacy> {
    const response = await fetch('http://localhost:8080/editDrugInPharmacy?' + 'pharmacyID=' + drugInPharmacy.pharmacy.pharmacyID +
      '&drugID=' + drugInPharmacy.drug.drugID + '&quantity=' + drugInPharmacy.quantity);
    if (response.ok) {
      let newDrugInPharmacy: DrugInPharmacy = await response.json();
      console.log(newDrugInPharmacy);
      return newDrugInPharmacy;
    } else {
      return drugInPharmacy;
    }
  }

  async delete(drugInPharmacy: DrugInPharmacy) {
    const response = await fetch('http://localhost:8080/deleteDrugInPharmacyByID?' + 'pharmacyID=' + drugInPharmacy.pharmacy.pharmacyID +
      '&drugID=' + drugInPharmacy.drug.drugID);
    if (response.ok) {
      this.drugsInPharmacies.splice(this.drugsInPharmacies.indexOf(drugInPharmacy), 1);
    } else {

    }
  }

  async add(drugInPharmacy: DrugInPharmacy) {
    const response = await fetch('http://localhost:8080/addDrugInPharmacy?' + 'pharmacyID=' + drugInPharmacy.pharmacy.pharmacyID +
      '&drugID=' + drugInPharmacy.drug.drugID + '&quantity=' + drugInPharmacy.quantity);
    if (response.ok) {
      this.drugInPharmacy = await response.json();
      console.log(this.drugInPharmacy);
      this.drugsInPharmacies.push(this.drugInPharmacy);
      this.drugInPharmacy = new DrugInPharmacy(new Pharmacy(0, '', 0, '', new Network(0, '', '', '')), new Drug(0, '', '', ''), 0);
    } else {

    }
  }

  ngOnInit(): void {
  }

}
