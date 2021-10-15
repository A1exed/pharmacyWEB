import { Component, OnInit } from '@angular/core';
import {Drug} from "../model/drug";

@Component({
  selector: 'app-drug',
  templateUrl: './drug.component.html',
  styleUrls: ['./drug.component.css']
})
export class DrugComponent implements OnInit {

  drugs: Drug[] = [];

  drug: Drug = new Drug(0, '', '', '');

  constructor() {
    this.getList();
  }

  async getList() {
    const response = await fetch('http://localhost:8080/getDrugList');
    if (response.ok) {
      this.drugs = await response.json();
      console.log(this.drugs);
    }
  }

  async edit(drug: Drug): Promise<Drug> {
    const response = await fetch('http://localhost:8080/editDrug?' + 'drugID=' + drug.drugID +
      '&drugName=' + drug.drugName + '&form=' + drug.form + '&manufacturerName=' + drug.manufacturerName);
    if (response.ok) {
      let newDrug: Drug = await response.json();
      console.log(newDrug);
      return newDrug;
    } else {
      return drug;
    }
  }

  async delete(drug: Drug) {
    const response = await fetch('http://localhost:8080/deleteDrugByID?' + 'drugID=' + drug.drugID);
    if (response.ok) {
      this.drugs.splice(this.drugs.indexOf(drug), 1);
    } else {

    }
  }

  async add(drug: Drug) {
    const response = await fetch('http://localhost:8080/addDrug?' + 'drugName=' + drug.drugName +
      '&form=' + drug.form + '&manufacturerName=' + drug.manufacturerName);
    if (response.ok) {
      this.drug = await response.json();
      console.log(this.drug);
      this.drugs.push(this.drug);
      this.drug = new Drug(0, '', '', '');
    } else {

    }
  }

  ngOnInit(): void {
  }

}
