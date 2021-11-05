import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  error: boolean = false;

  constructor(public app: AppService, public router: Router) {
    if (app.authenticated) {
      router.navigateByUrl('main');
    }
  }

  ngOnInit(): void {
  }

}
