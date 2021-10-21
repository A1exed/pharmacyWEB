import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {

  constructor(public app: AppService, public router: Router) {
    if (app.authenticated) {
      router.navigateByUrl('main');
    }
  }

  ngOnInit(): void {
  }

}
