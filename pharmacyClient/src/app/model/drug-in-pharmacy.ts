import {Pharmacy} from "./pharmacy";
import {Drug} from "./drug";

export class DrugInPharmacy {

  private _pharmacy: Pharmacy;
  private _drug: Drug;
  private _quantity: number;

  constructor(pharmacy: Pharmacy, drug: Drug, quantity: number) {
    this._pharmacy = pharmacy;
    this._drug = drug;
    this._quantity = quantity;
  }

  get pharmacy(): Pharmacy {
    return this._pharmacy;
  }

  set pharmacy(value: Pharmacy) {
    this._pharmacy = value;
  }

  get drug(): Drug {
    return this._drug;
  }

  set drug(value: Drug) {
    this._drug = value;
  }

  get quantity(): number {
    return this._quantity;
  }

  set quantity(value: number) {
    this._quantity = value;
  }
}
