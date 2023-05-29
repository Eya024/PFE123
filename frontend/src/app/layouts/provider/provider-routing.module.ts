import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProviderComponent } from './provider.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AppointmentsComponent } from './appointments/appointments.component';
import { ScheduleComponent } from './schedule/schedule.component';
import { CustomersComponent } from './customers/customers.component';
import { InvoicesComponent } from './invoices/invoices.component';
import { ProfileComponent } from './profile/profile.component';

export const ProviderRoutes: Routes = [

  {
    path: 'dashboard',
    component: DashboardComponent
  },
  {
    path: 'appointments',
    component: AppointmentsComponent
  },
  {
    path: 'schedule',
    component: ScheduleComponent
  },
  {
    path: 'customers',
    component: CustomersComponent
  },
  {
    path: 'invoices',
    component: InvoicesComponent
  },
  {
    path: 'profile',
    component: ProfileComponent
  }



];
