import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  pending: boolean;

  constructor() { }

  ngOnInit() {
    this.pending = false;
  }

}
