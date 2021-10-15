import {Network} from "./network";

export class Pharmacy {

  private _pharmacyID: number;
  private _address: string;
  private _rating: number;
  private _phoneNumber: string;
  private _network: Network;

  constructor(pharmacyID: number, address: string, rating: number, phoneNumber: string, network: Network) {
    this._pharmacyID = pharmacyID;
    this._address = address;
    this._rating = rating;
    this._phoneNumber = phoneNumber;
    this._network = network;
  }

  get pharmacyID(): number {
    return this._pharmacyID;
  }

  set pharmacyID(value: number) {
    this._pharmacyID = value;
  }

  get address(): string {
    return this._address;
  }

  set address(value: string) {
    this._address = value;
  }

  get rating(): number {
    return this._rating;
  }

  set rating(value: number) {
    this._rating = value;
  }

  get phoneNumber(): string {
    return this._phoneNumber;
  }

  set phoneNumber(value: string) {
    this._phoneNumber = value;
  }

  get network(): Network {
    return this._network;
  }

  set network(value: Network) {
    this._network = value;
  }
}
