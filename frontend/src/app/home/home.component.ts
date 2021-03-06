import { Component, OnInit } from '@angular/core';
import {AuthService} from "../services/auth.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  getCurrentUsername(): string {
    return AuthService.getCurrentUsername();
  }

  isLoggedIn(): boolean {
    return AuthService.isLoggedIn();
  }

  logout() {
    AuthService.logout();
  }

}
