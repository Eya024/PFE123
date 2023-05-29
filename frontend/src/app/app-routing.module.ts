import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './layouts/admin/admin.component';
import { HomepageComponent } from './layouts/homepage/homepage.component';
import { CustomerComponent } from './layouts/customer/customer.component';
import { ProviderComponent } from './layouts/provider/provider.component';
import { AuthGuardService } from './core/services/auth-guard/auth-guard.service';

const routes: Routes = [
  { 
    path: 'admin',
    component: AdminComponent,
    // canActivate :[AuthGuardService],
      loadChildren: () => import('./layouts/admin/admin.module').then(m => m.AdminModule)
  },
  {
    path: 'homepage',
    component: HomepageComponent,
    loadChildren: () => import('./layouts/homepage/homepage.module').then(m => m.HomepageModule)
  },
  {
    path: 'customer',
    component: CustomerComponent,
    //canActivate :[AuthGuardService],
    loadChildren: () => import('./layouts/customer/customer.module').then(m => m.CustomerModule)
  },
  {
    path: 'provider',
    component: ProviderComponent,
     //canActivate :[AuthGuardService],
    loadChildren: () => import('./layouts/provider/provider.module').then(m => m.ProviderModule)
  },
  {
    path: '',
    redirectTo: '/homepage/welcome',
    pathMatch: 'full'
  },

];
@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    CommonModule,
    BrowserModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
