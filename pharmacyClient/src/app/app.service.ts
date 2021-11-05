import { Injectable } from '@angular/core';
import { User } from "./model/user";
import {Router} from "@angular/router";

@Injectable()
export class AppService {

  authenticated = false;

  user: User = new User('', '', '', '');

  serverURL: string = 'http://localhost:8080';

  role: string = '';

  isAdmin: boolean = false;

  constructor(public router: Router) { }

  async login() {
    const u = {
      username: this.user.username,
      password: this.user.password
    }
    const response = await fetch(this.serverURL + this.role + '/auth', {
      method: 'POST',
      headers: new Headers({
        'Content-Type': 'application/json;charset=utf-8'
      }),
      body: JSON.stringify(u)
    });
    this.authenticated = response.ok;
    if (this.authenticated) {
      this.user = await response.json();
      switch (this.user.role) {
        case 'ROLE_ADMIN':
          this.role = '/admin';
          this.isAdmin = true;
          break;
        case 'ROLE_USER':
          this.role = '/user';
          this.isAdmin = false;
          break;
        default:
          this.role = '';
      }
      await this.router.navigateByUrl('main');
    } else {
      alert('Неверный логин или пароль!');
    }
  }

  async register() {
    const u = {
      username: this.user.username,
      password: this.user.password
    }
    const response = await fetch(this.serverURL + this.role + '/register', {
      method: 'POST',
      headers: new Headers({
        'Content-Type': 'application/json;charset=utf-8'
      }),
      body: JSON.stringify(u)
    });
    if (response.ok) {
      this.user = new User('', '', '', '');
      await this.router.navigateByUrl('');
    } else {
      alert('Данное имя пользователя уже занято!');
    }
  }

  logout() {
    this.authenticated = false;
    this.user = new User('', '', '', '');
    this.role = '';
    this.isAdmin = false;
    this.router.navigateByUrl('');
  }

}
