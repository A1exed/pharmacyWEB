import {Component, OnInit} from '@angular/core';
import {Network} from "../model/network";
import {AppService} from "../app.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-network',
  templateUrl: './network.component.html',
  styleUrls: ['./network.component.css']
})
export class NetworkComponent implements OnInit {

  networks: Network[] = [];

  network: Network = new Network(0, '', '', '');

  constructor(public app: AppService, public router: Router) {
    if (!app.authenticated) {
      router.navigateByUrl('');
    } else {
      this.getList();
    }
  }

  async getList() {
    const response = await fetch(this.app.serverURL + this.app.role + '/getNetworkList', {
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
        this.networks = await response.json();
      } else {
        alert('Сервис недоступен');
      }
    }
  }

  async edit(network: Network): Promise<Network> {
    const response = await fetch(this.app.serverURL + this.app.role + '/editNetwork?' + 'networkID=' + network.networkID +
      '&networkName=' + network.networkName + '&phoneNumber=' + network.phoneNumber + '&owner=' + network.owner, {
      method: 'GET',
      headers: new Headers({
        'Authorization': 'Bearer ' + this.app.user.token,
        'Content-Type': 'application/json;charset=utf-8'
      })
    });
    if (response.status === 401) {
      await this.router.navigateByUrl('');
      return network;
    } else {
      if (response.ok) {
        return await response.json();
      } else {
        alert('Сервис недоступен');
        return network;
      }
    }
  }

  async delete(network: Network) {
    const response = await fetch(this.app.serverURL + this.app.role + '/deleteNetworkByID?' + 'networkID=' + network.networkID, {
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
        this.networks.splice(this.networks.indexOf(network), 1);
      } else {
        alert('Сервис недоступен');
      }
    }
  }

  async add(network: Network) {
    const response = await fetch(this.app.serverURL + this.app.role + '/addNetwork?' + 'networkName=' + network.networkName +
        '&phoneNumber=' + network.phoneNumber + '&owner=' + network.owner, {
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
        this.network = await response.json();
        this.networks.push(this.network);
        this.network = new Network(0, '', '', '');
      } else {
        alert('Сервис недоступен');
      }
    }
  }

  ngOnInit(): void {
  }

}
