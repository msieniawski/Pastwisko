import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/toPromise";
import {User} from "../model/user";

@Injectable()
export class UserService {

  private usersUrl = 'api/users/';

  constructor(private http: Http) { }

  getUser(id: number): Promise<User> {
    return this.http.get(this.usersUrl + id.toString())
      .toPromise().then(response => response.json() as User)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
