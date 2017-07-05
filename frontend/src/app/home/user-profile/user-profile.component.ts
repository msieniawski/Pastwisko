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
    const id = this.route.snapshot.params['id'];
    this.getUser(id);
  }

  getUser(id: number) {
    this.userService.getUser(id).then(user => this.user = user);
  }

}
