import { Injectable } from '@angular/core';
import { User } from "./model/user";
import {Router} from "@angular/router";

@Injectable()
export class AppService {

  authenticated = false;

  user: User = new User('', '');

  auth: string = '';

  serverURL: string = 'http://localhost:8080';

  constructor(public router: Router) { }

  async login() {
    this.auth = btoa(this.user.username + ':' + this.user.password);
    this.user = new User('', '');
    const response = await fetch(this.serverURL + '/login', {
      method: 'GET',
      headers: new Headers({
        'Authorization': 'Basic ' + this.auth,
        'Content-Type': 'application/json;charset=utf-8'
      })
    });
    this.authenticated = response.ok;
    if (this.authenticated) {
      await this.router.navigateByUrl('main');
    } else {
      alert('Неверный логин или пароль!');
    }
  }

}
