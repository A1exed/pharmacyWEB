export class Network {
  private _networkID: number;
  private _networkName: string;
  private _phoneNumber: string;
  private _owner: string;

  constructor(networkID: number, networkName: string, phoneNumber: string, owner: string) {
    this._networkID = networkID;
    this._networkName = networkName;
    this._phoneNumber = phoneNumber;
    this._owner = owner;
  }

  get networkID(): number {
    return this._networkID;
  }

  set networkID(value: number) {
    this._networkID = value;
  }

  get networkName(): string {
    return this._networkName;
  }

  set networkName(value: string) {
    this._networkName = value;
  }

  get phoneNumber(): string {
    return this._phoneNumber;
  }

  set phoneNumber(value: string) {
    this._phoneNumber = value;
  }

  get owner(): string {
    return this._owner;
  }

  set owner(value: string) {
    this._owner = value;
  }
}
