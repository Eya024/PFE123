import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { AuthService } from '../auth/auth.service';
import { Observable } from 'rxjs';
import { StorageService } from '../storage/storage.service';
import { RoleStatus } from '../../models/roles';

@Injectable({
    providedIn: 'root'
})
export class AuthGuardService implements CanActivate {
    role: RoleStatus;

    constructor(private authService: StorageService, private router: Router) { }

    canActivate(
        route: ActivatedRouteSnapshot,
        state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
          
        if (this.authService.isLoggedIn()) {
          const roles = this.authService.getUser()?.roles;
          const currentRoute = state.url;
      
          if (roles.includes(RoleStatus.CUSTOMER) && currentRoute !== '/customer') {
            // Redirect to the customer layout
            return this.router.parseUrl('/customer');
          } else if (roles.includes(RoleStatus.PROVIDER) && currentRoute !== '/provider') {
            // Redirect to the provider layout
            return this.router.parseUrl('/provider');
          } else if (roles.includes(RoleStatus.ADMIN) && currentRoute !== '/admin') {
            // Redirect to the admin layout
            return this.router.parseUrl('/admin');
          }
          
          // User has a matching role for the current route, allow access
          return true;
        } else {
          // User is not authenticated, redirect to login page
          return this.router.parseUrl('/homepage/login');
        }
      }
}