export class Drug {

  private _drugID: number;

  private _drugName: string;

  private _form: string;

  private _manufacturerName: string;

  constructor(drugID: number, drugName: string, form: string, manufacturerName: string) {
    this._drugID = drugID;
    this._drugName = drugName;
    this._form = form;
    this._manufacturerName = manufacturerName;
  }

  get drugID(): number {
    return this._drugID;
  }

  set drugID(value: number) {
    this._drugID = value;
  }

  get drugName(): string {
    return this._drugName;
  }

  set drugName(value: string) {
    this._drugName = value;
  }

  get form(): string {
    return this._form;
  }

  set form(value: string) {
    this._form = value;
  }

  get manufacturerName(): string {
    return this._manufacturerName;
  }

  set manufacturerName(value: string) {
    this._manufacturerName = value;
  }
}
