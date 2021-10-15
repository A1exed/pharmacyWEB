import { Component, OnInit } from '@angular/core';
import {Pharmacy} from "../model/pharmacy";
import {Network} from "../model/network";

@Component({
  selector: 'app-pharmacy',
  templateUrl: './pharmacy.component.html',
  styleUrls: ['./pharmacy.component.css']
})
export class PharmacyComponent implements OnInit {

  pharmacies: Pharmacy[] = [];

  pharmacy: Pharmacy = new Pharmacy(0, '', 0, '', new Network(0, '', '', ''));

  networks: Network[] = [];

  constructor() {
    this.getList();
  }

  async getList() {
    const response = await fetch('http://localhost:8080/getPharmacyList');
    const response1 = await fetch('http://localhost:8080/getNetworkList');
    if (response.ok && response1.ok) {
      this.pharmacies = await response.json();
      console.log(this.pharmacies);
      this.networks = await response1.json();
      console.log(this.networks);
    } else {

    }
  }

  async edit(pharmacy: Pharmacy): Promise<Pharmacy> {
    const response = await fetch('http://localhost:8080/editPharmacy?' + 'pharmacyID=' + pharmacy.pharmacyID +
        '&address=' + pharmacy.address + '&rating=' + pharmacy.rating + '&phoneNumber=' + pharmacy.phoneNumber +
        '&networkID=' + pharmacy.network.networkID);
    if (response.ok) {
      let newPharmacy: Pharmacy = await response.json();
      console.log(newPharmacy);
      return newPharmacy;
    } else {
      return pharmacy;
    }
  }

  async delete(pharmacy: Pharmacy) {
    const response = await fetch('http://localhost:8080/deletePharmacyByID?' + 'pharmacyID=' + pharmacy.pharmacyID);
    if (response.ok) {
      this.pharmacies.splice(this.pharmacies.indexOf(pharmacy), 1);
    } else {

    }
  }

  async add(pharmacy: Pharmacy) {
    const response = await fetch('http://localhost:8080/addPharmacy?' + 'address=' + pharmacy.address +
      '&rating=' + pharmacy.rating + '&phoneNumber=' + pharmacy.phoneNumber + '&networkID=' + pharmacy.network.networkID);
    if (response.ok) {
      this.pharmacy = await response.json();
      console.log(this.pharmacy);
      this.pharmacies.push(this.pharmacy);
      this.pharmacy = new Pharmacy(0, '', 0, '', new Network(0, '', '', ''));
    } else {

    }
  }

  ngOnInit(): void {
  }

}
