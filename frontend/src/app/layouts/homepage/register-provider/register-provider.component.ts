import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/core/services/auth/auth.service';

@Component({
  selector: 'app-register-provider',
  templateUrl: './register-provider.component.html',
  styleUrls: ['./register-provider.component.css']
})
export class RegisterProviderComponent implements OnInit {
  form: any = {
    username: null,
    email: null,
    password: null,
    firstName:null,
    lastName:null,
    mobile:null,
    street:null,
    city:null,
    postcode:null
  };
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService, private router : Router) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    const { username, email, password, firstName, lastName, mobile, street, city, postcode } = this.form;


    this.authService.register(username, email, password, ['PROVIDER']).subscribe({
      next: data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        this.router.navigate(['/homepage/login']);

      },
      error: err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    });
    
  }
}
