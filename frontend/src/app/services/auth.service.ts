import {Injectable} from '@angular/core';
import {Http, Headers, Response} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class AuthService {

  private authUrl = 'api/auth/';
  private headers = new Headers({'Content-Type': 'application/json'});

  static getToken(): string {
    const currentUser = JSON.parse(localStorage.getItem('currentUser'));
    const token = currentUser && currentUser.token;
    return token ? token : "";
  }

  static getCurrentUsername(): string {
    const currentUser = JSON.parse(localStorage.getItem('currentUser'));
    const username = currentUser && currentUser.username;
    return username ? username : "";
  }

  static isLoggedIn(): boolean {
    const token: String = AuthService.getToken();
    return token && token.length > 0;
  }

  static logout(): void {
    localStorage.removeItem('currentUser');
  }

  constructor(private http: Http) {
  }

  login(username: string, password: string): Observable<boolean> {
    return this.http.post(this.authUrl + "login", JSON.stringify({username: username, password: password}), {headers: this.headers})
      .map((response: Response) => {
        const token = response.headers.get('Authorization');
        if (token) {
          localStorage.setItem('currentUser', JSON.stringify({username: username, token: token}));
          return true;
        } else {
          return false;
        }
      }).catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  loginWithFB(fbToken: string, fbUser: string): Observable<boolean> {
    return this.http.post(this.authUrl + "login/fb", JSON.stringify({token: fbToken}), {headers: this.headers})
      .map((response: Response) => {
        const token = response.headers.get('Authorization');
        if (token) {
          localStorage.setItem('currentUser', JSON.stringify({username: fbUser, token: token}));
          return true;
        } else {
          return false;
        }
      }).catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  register(email: string, username: string, password: string): Observable<boolean> {
    return this.http.post(this.authUrl + "register",
      JSON.stringify({email: email, username: username, password: password}), {headers: this.headers})
      .map((response: Response) => {
        return response.ok;
      }).catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }
}
