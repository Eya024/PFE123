import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginComponent } from './login/login.component';
import { RouterModule } from '@angular/router';
import { HomepageRoutes } from './homepage-routing.module';
import { RegisterComponent } from '../register/register.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { RegisterProviderComponent } from './register-provider/register-provider.component';
import { RegisterAdminComponent } from '../admin/register-admin/register-admin.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    LoginComponent,
    RegisterComponent,
    ForgotPasswordComponent,
    WelcomeComponent,
    RegisterProviderComponent,
    RegisterAdminComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(HomepageRoutes),
    FormsModule
  ]
})
export class HomepageModule { }
