import {Injectable} from "@angular/core";
import {Headers, Http} from "@angular/http";
import "rxjs/add/operator/toPromise";
import {User} from "../model/user";
import {AuthService} from "./auth.service";

@Injectable()
export class UserService {

  private headers = new Headers({'Content-Type': 'application/json', 'Authorization': 'Bearer ' + AuthService.getToken()});
  private usersUrl = 'api/users/';

  constructor(private http: Http) { }

  getUser(username: string): Promise<User> {
    return this.http.get(this.usersUrl + username, {headers: this.headers})
      .toPromise().then(response => response.json() as User)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
