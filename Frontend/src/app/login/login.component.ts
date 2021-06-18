import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import {AuthService} from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm = this.formBuilder.group({
    username: '',
    password: ''
  });

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    ) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    // console.log(this.authService.isValidLogin(this.loginForm.value.username, this.loginForm.value.password));
    // console.warn('Your order has been submitted', this.loginForm.value);

    this.authService.isValidLogin(this.loginForm.value.username, this.loginForm.value.password)
      .subscribe(data => {
        console.log(data)
      })      
    this.loginForm.reset();

  }

}
