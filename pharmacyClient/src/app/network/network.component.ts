import { Component, OnInit } from '@angular/core';
import {Network} from "../model/network";

@Component({
  selector: 'app-network',
  templateUrl: './network.component.html',
  styleUrls: ['./network.component.css']
})
export class NetworkComponent implements OnInit {

  networks: Network[] = [];

  network: Network = new Network(0, '', '', '');

  constructor() {
    this.getList();
  }

  async getList() {
    const response = await fetch('http://localhost:8080/getNetworkList');
    if (response.ok) {
      this.networks = await response.json();
      console.log(this.networks);
    }
  }

  async edit(network: Network): Promise<Network> {
    const response = await fetch('http://localhost:8080/editNetwork?' + 'networkID=' + network.networkID +
      '&networkName=' + network.networkName + '&phoneNumber=' + network.phoneNumber + '&owner=' + network.owner);
    if (response.ok) {
      let newNetwork: Network = await response.json();
      console.log(newNetwork);
      return newNetwork;
    } else {
      return network;
    }
  }

  async delete(network: Network) {
    const response = await fetch('http://localhost:8080/deleteNetworkByID?' + 'networkID=' + network.networkID);
    if (response.ok) {
      this.networks.splice(this.networks.indexOf(network), 1);
    } else {

    }
  }

  async add(network: Network) {
    const response = await fetch('http://localhost:8080/addNetwork?' + 'networkName=' + network.networkName +
        '&phoneNumber=' + network.phoneNumber + '&owner=' + network.owner);
    if (response.ok) {
      this.network = await response.json();
      console.log(this.network);
      this.networks.push(this.network);
      this.network = new Network(0, '', '', '');
    } else {

    }
  }

  ngOnInit(): void {
  }

}
