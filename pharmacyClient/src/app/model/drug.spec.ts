import { Drug } from './drug';

describe('Drug', () => {
  it('should create an instance', () => {
    expect(new Drug(0, '', '', '')).toBeTruthy();
  });
});
