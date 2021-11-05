import {Component, OnInit} from '@angular/core';
import {Pharmacy} from "../model/pharmacy";
import {Network} from "../model/network";
import {AppService} from "../app.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-pharmacy',
  templateUrl: './pharmacy.component.html',
  styleUrls: ['./pharmacy.component.css']
})
export class PharmacyComponent implements OnInit {

  pharmacies: Pharmacy[] = [];

  pharmacy: Pharmacy = new Pharmacy(0, '', 0, '', new Network(0, '', '', ''));

  networks: Network[] = [];

  constructor(public app: AppService, public router: Router) {
    if (!app.authenticated) {
      router.navigateByUrl('');
    } else {
      this.getList();
    }
  }

  async getList() {
    const response = await fetch(this.app.serverURL + this.app.role + '/getPharmacyList', {
      method: 'GET',
      headers: new Headers({
        'Authorization': 'Bearer ' + this.app.user.token,
        'Content-Type': 'application/json;charset=utf-8'
      })
    });
    const response1 = await fetch(this.app.serverURL + this.app.role + '/getNetworkList', {
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
        this.pharmacies = await response.json();
        this.networks = await response1.json();
      } else {
        alert('Сервис недоступен');
      }
    }
  }

  async edit(pharmacy: Pharmacy): Promise<Pharmacy> {
    const response = await fetch(this.app.serverURL + this.app.role + '/editPharmacy?' + 'pharmacyID=' + pharmacy.pharmacyID +
        '&address=' + pharmacy.address + '&rating=' + pharmacy.rating + '&phoneNumber=' + pharmacy.phoneNumber +
        '&networkID=' + pharmacy.network.networkID, {
      method: 'GET',
      headers: new Headers({
        'Authorization': 'Bearer ' + this.app.user.token,
        'Content-Type': 'application/json;charset=utf-8'
      })
    });
    if (response.status === 401) {
      await this.router.navigateByUrl('');
      return pharmacy;
    } else {
      if (response.ok) {
        return await response.json();
      } else {
        alert('Сервис недоступен');
        return pharmacy;
      }
    }
  }

  async delete(pharmacy: Pharmacy) {
    const response = await fetch(this.app.serverURL + this.app.role + '/deletePharmacyByID?' + 'pharmacyID=' + pharmacy.pharmacyID, {
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
        this.pharmacies.splice(this.pharmacies.indexOf(pharmacy), 1);
      } else {
        alert('Сервис недоступен');
      }
    }
  }

  async add(pharmacy: Pharmacy) {
    const response = await fetch(this.app.serverURL + this.app.role + '/addPharmacy?' + 'address=' + pharmacy.address +
      '&rating=' + pharmacy.rating + '&phoneNumber=' + pharmacy.phoneNumber + '&networkID=' + pharmacy.network.networkID, {
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
        this.pharmacy = await response.json();
        this.pharmacies.push(this.pharmacy);
        this.pharmacy = new Pharmacy(0, '', 0, '', new Network(0, '', '', ''));
      } else {
        alert('Сервис недоступен');
      }
    }
  }

  ngOnInit(): void {
  }

}
