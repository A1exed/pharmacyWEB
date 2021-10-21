import { DrugInPharmacy } from './drug-in-pharmacy';
import {Pharmacy} from "./pharmacy";
import {Network} from "./network";
import {Drug} from "./drug";

describe('DrugInPharmacy', () => {
  it('should create an instance', () => {
    expect(new DrugInPharmacy(new Pharmacy(0, '', 0, '', new Network(0, '', '', '')), new Drug(0, '', '', ''), 0)).toBeTruthy();
  });
});
