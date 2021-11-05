import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';
import { FormsModule} from "@angular/forms";

import { AppComponent } from './app.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { MainComponent } from './main/main.component';
import { AuthComponent } from './auth/auth.component';
import { HeaderComponent } from './header/header.component';
import { NetworkComponent } from './network/network.component';
import { PharmacyComponent } from './pharmacy/pharmacy.component';
import { EmployeeComponent } from './employee/employee.component';
import { DrugInPharmacyComponent } from './drug-in-pharmacy/drug-in-pharmacy.component';
import { DrugComponent } from './drug/drug.component';

import { AppService } from "./app.service";
import { RegisterComponent } from './register/register.component';


const appRoutes: Routes = [
  { path: '', component: AuthComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'main', component: MainComponent },
  { path: 'main/networks', component: NetworkComponent },
  { path: 'main/pharmacies', component: PharmacyComponent},
  { path: 'main/employees', component: EmployeeComponent },
  { path: 'main/drugs_in_pharmacies', component: DrugInPharmacyComponent },
  { path: 'main/drugs', component: DrugComponent },
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    NotFoundComponent,
    MainComponent,
    AuthComponent,
    HeaderComponent,
    NetworkComponent,
    PharmacyComponent,
    EmployeeComponent,
    DrugInPharmacyComponent,
    DrugComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    FormsModule
  ],
  providers: [AppService],
  bootstrap: [AppComponent]
})
export class AppModule { }
