import { Employee } from './employee';
import {Pharmacy} from "./pharmacy";
import {Network} from "./network";

describe('Employee', () => {
  it('should create an instance', () => {
    expect(new Employee(0, '', '', '', new Pharmacy(0, '', 0, '', new Network(0, '', '', '')))).toBeTruthy();
  });
});
