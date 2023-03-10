import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Dashboard02Component } from './dashboard02/dashboard02.component';
import { HeaderComponent } from './header/header.component';
import { Header2Component } from './header2/header2.component';
import { LoginComponent } from './login/login.component';
import { LoginguardGuard } from './loginguard.guard';
import { RegisterComponent } from './register/register.component';


const routes: Routes = [
  {
    path: "",
    component: HeaderComponent,
    children: [
      {
        path: "registerurl",
        component: RegisterComponent
      },
      {
        path: "loginurl",
        component: LoginComponent
      },
     
    ]
  },
  {
    path:"header2",
    component:Header2Component,
    canActivate:[LoginguardGuard]
  },
  {
    path:"details",
    component:Dashboard02Component
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
