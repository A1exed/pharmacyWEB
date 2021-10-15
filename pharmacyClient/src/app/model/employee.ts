import {Pharmacy} from "./pharmacy";

export class Employee {

  private _employeeID: number;
  private _employeeName: string;
  private _position: string;
  private _phoneNumber: string;
  private _pharmacy: Pharmacy;

  constructor(employeeID: number, employeeName: string, position: string, phoneNumber: string, pharmacy: Pharmacy) {
    this._employeeID = employeeID;
    this._employeeName = employeeName;
    this._position = position;
    this._phoneNumber = phoneNumber;
    this._pharmacy = pharmacy;
  }

  get employeeID(): number {
    return this._employeeID;
  }

  set employeeID(value: number) {
    this._employeeID = value;
  }

  get employeeName(): string {
    return this._employeeName;
  }

  set employeeName(value: string) {
    this._employeeName = value;
  }

  get position(): string {
    return this._position;
  }

  set position(value: string) {
    this._position = value;
  }

  get phoneNumber(): string {
    return this._phoneNumber;
  }

  set phoneNumber(value: string) {
    this._phoneNumber = value;
  }

  get pharmacy(): Pharmacy {
    return this._pharmacy;
  }

  set pharmacy(value: Pharmacy) {
    this._pharmacy = value;
  }
}
