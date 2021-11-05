export class User {

  private _username: string;
  private _password: string;
  private _role: string;
  private _token: string;

  constructor(username: string, password: string, role: string, token: string) {
    this._username = username;
    this._password = password;
    this._role = role;
    this._token = token;
  }

  get username(): string {
    return this._username;
  }

  set username(value: string) {
    this._username = value;
  }

  get password(): string {
    return this._password;
  }

  set password(value: string) {
    this._password = value;
  }

  get role(): string {
    return this._role;
  }

  set role(value: string) {
    this._role = value;
  }

  get token(): string {
    return this._token;
  }

  set token(value: string) {
    this._token = value;
  }
}
