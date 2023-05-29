import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from './homepage.component';
import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { RegisterComponent } from '../register/register.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { RegisterProviderComponent } from './register-provider/register-provider.component';
import { RegisterAdminComponent } from '../admin/register-admin/register-admin.component';

export const HomepageRoutes: Routes = [
{
    path: 'login',
    component: LoginComponent
  },
  {

    path: 'register-customer',
    component: RegisterComponent
  },
  {
    path: 'register-provider',
    component: RegisterProviderComponent
  },
  {
    path: 'register-admin',
    component: RegisterAdminComponent
  },
  {
    path: 'forgot-password',
    component: ForgotPasswordComponent
  },
  {
    path: 'welcome',
    component: WelcomeComponent
  }

];
