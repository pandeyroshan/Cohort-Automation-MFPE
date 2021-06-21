import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}

@Component({
  selector: 'app-reset-link-sent',
  templateUrl: './reset-link-sent.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ResetLinkSent implements OnInit {
  constructor(){ }

  ngOnInit(): void {
  }
}