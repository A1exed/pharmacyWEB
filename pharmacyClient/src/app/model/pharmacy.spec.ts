import { Pharmacy } from './pharmacy';
import {Network} from "./network";

describe('Pharmacy', () => {
  it('should create an instance', () => {
    expect(new Pharmacy(0, '', 0, '', new Network(0, '', '', ''))).toBeTruthy();
  });
});
