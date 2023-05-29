import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../../models/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private customerUrl = 'http://localhost:8080/api/customers';  // URL to REST API

  constructor(private http: HttpClient) { }

  /** GET users from the server */
  showAllCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.customerUrl + '/all');
  }
  
  /** GET user by id. Will 404 if id not found */
  showCustomerDetails(id: number): Observable<any> {
    const url = `${this.customerUrl}/get-truck/${id}`;
    return this.http.get<Customer>(url);
  }
  
  /** POST: add a new user to the server */
  addTruck(truck: Customer) {
    return this.http.post(this.customerUrl + '/add-truck', truck);
  }
  
  /** PUT: update the user on the server */
  updateTruck(id ,truck: Customer) {
    return this.http.put(this.customerUrl + `/update-truck/${id}`, truck);
  }
  
  /** DELETE: delete the user from the server */
  deleteTruck(id: number) {
    return this.http.delete(this.customerUrl + `/delete-truck/${id}`);
  }

  

  
}