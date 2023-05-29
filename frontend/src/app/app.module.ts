import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerSidebarComponent } from './shared/customer-sidebar/customer-sidebar.component';
import { FooterComponent } from './shared/footer/footer.component';
import { HeaderComponent } from './shared/header/header.component';
import { NotfoundComponent } from './shared/notfound/notfound.component';
import { ProviderSidebarComponent } from './shared/provider-sidebar/provider-sidebar.component';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminSidebarComponent } from './shared/admin-sidebar/admin-sidebar.component';
import { AdminComponent } from './layouts/admin/admin.component';
import { ProviderComponent } from './layouts/provider/provider.component';
import { HomepageComponent } from './layouts/homepage/homepage.component';
import { CustomerComponent } from './layouts/customer/customer.component';
import { httpInterceptorProviders } from './core/helpers/http.interceptor';
import { HeaderAdminComponent } from './shared/header-admin/header-admin.component';


@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    ProviderComponent,
    HomepageComponent,
    CustomerComponent,

    HeaderComponent,
    FooterComponent,
    AdminSidebarComponent,
    CustomerSidebarComponent,
    ProviderSidebarComponent,
    NotfoundComponent,
    HeaderAdminComponent,

 

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,

    
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
