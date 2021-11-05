import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  constructor(public app: AppService, public router: Router) {
    if (!app.authenticated) {
      router.navigateByUrl('');
    }
  }

  ngOnInit(): void {
  }

}
