import { Component, OnInit } from '@angular/core';
import {User} from "../../model/user";
import {ActivatedRoute} from "@angular/router";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
  providers: [UserService]
})
export class UserProfileComponent implements OnInit {

  user: User;

  constructor(private route: ActivatedRoute, private userService: UserService) { }

  ngOnInit() {
    const username = this.route.snapshot.params['username'];
    this.getUser(username);
  }

  getUser(username: string) {
    this.userService.getUser(username).then(user => this.user = user);
  }

}
