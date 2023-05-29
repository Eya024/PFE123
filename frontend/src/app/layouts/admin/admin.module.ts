import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminRoutes } from './admin-routing.module';
import { RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AppointmentsComponent } from './appointments/appointments.component';
import { SpecialitiesComponent } from './specialities/specialities.component';
import { ProvidersComponent } from './providers/providers.component';
import { CustomersComponent } from './customers/customers.component';
import { TransactionsComponent } from './transactions/transactions.component';
import { SettingsComponent } from './settings/settings.component';
import { InvoicesComponent } from './invoices/invoices.component';
import { ProfileComponent } from './profile/profile.component';




@NgModule({
  declarations: [
  
    DashboardComponent,
       AppointmentsComponent,
       SpecialitiesComponent,
       ProvidersComponent,
       CustomersComponent,
       TransactionsComponent,
       SettingsComponent,
       InvoicesComponent,
       ProfileComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(AdminRoutes),
  ]
})
export class AdminModule {}