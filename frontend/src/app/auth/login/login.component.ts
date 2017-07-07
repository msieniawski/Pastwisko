import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../../services/auth.service";
import {FacebookService, InitParams, LoginResponse} from "ngx-facebook";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [AuthService]
})
export class LoginComponent implements OnInit {

  private pending: boolean;
  private username: string;
  private password: string;
  private error: string;

  constructor(private router: Router, private authService: AuthService, private fb: FacebookService) { }

ngOnInit() {
  this.pending = false;
  const initParams: InitParams = {
    appId: '1312120852189732',
    xfbml: true,
    version: 'v2.9'
  };
  this.fb.init(initParams);
}

  login() {
    this.pending = true;
    this.authService.login(this.username, this.password)
      .subscribe(result => {
        if (result === true) {
          this.router.navigate(['home']);
        } else {
          this.error = 'Unknown error';
          this.pending = false;
        }
      }, error => {
        this.pending = false;
        this.error = error;
      });
  }

  loginWithFacebook(): void {
    this.pending = true;
    this.fb.login()
      .then((response: LoginResponse) => {
        this.fb.api('/me').then((res) => {
          this.authService.loginWithFB(response.authResponse.accessToken, res.name);
          this.pending = false;
        });
      })
      .catch((error: any) => {
        this.pending = false;
        this.error = error;
      });
  }

}
