import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProviderRoutes} from './provider-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { RouterModule } from '@angular/router';
import { AppointmentsComponent } from './appointments/appointments.component';
import { ScheduleComponent } from './schedule/schedule.component';
import { CustomersComponent } from './customers/customers.component';
import { InvoicesComponent } from './invoices/invoices.component';
import { ProfileComponent } from './profile/profile.component';
import { FullcalendarComponent } from './fullcalendar/fullcalendar.component';


@NgModule({
  declarations: [
  
    DashboardComponent,
       AppointmentsComponent,
       ScheduleComponent,
       CustomersComponent,
       InvoicesComponent,
       ProfileComponent,
       FullcalendarComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(ProviderRoutes),
  ]
})
export class ProviderModule { }
