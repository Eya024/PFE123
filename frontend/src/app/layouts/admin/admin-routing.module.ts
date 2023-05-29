import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AppointmentsComponent } from './appointments/appointments.component';
import { SpecialitiesComponent } from './specialities/specialities.component';
import { ProviderComponent } from '../provider/provider.component';
import { CustomerComponent } from '../customer/customer.component';
import { ProfileComponent } from './profile/profile.component';
import { ProvidersComponent } from './providers/providers.component';
import { CustomersComponent } from './customers/customers.component';
import { InvoicesComponent } from './invoices/invoices.component';
import { SettingsComponent } from './settings/settings.component';
import { TransactionsComponent } from './transactions/transactions.component';

export const AdminRoutes: Routes = [  
    {
        path: 'dashboard',
        component: DashboardComponent
      
      }, 
      {
        path: 'appointments',
        component: AppointmentsComponent
      
      }, 
      {
        path: 'specialities',
        component: SpecialitiesComponent
      
      }, 
      {
        path: 'customers',
        component: CustomersComponent
      
      }, 
      {
        path: 'profile',
        component: ProfileComponent
      
      }, 
      {
        path: 'providers',
        component: ProvidersComponent
      
      }, 
      {
        path: 'invoices',
        component: InvoicesComponent
      
      }, 
      {
        path: 'settings',
        component: SettingsComponent
      
      },
      {
        path: 'transactions',
        component: TransactionsComponent
      
      },  

      
      


    
];
