import { Network } from './network';

describe('Network', () => {
  it('should create an instance', () => {
    expect(new Network(0, '', '', '')).toBeTruthy();
  });
});
