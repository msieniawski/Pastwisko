import {Injectable} from "@angular/core";
import {Headers, Http} from "@angular/http";
import "rxjs/add/operator/toPromise";
import {Tag} from "../model/tag";
import {AuthService} from "./auth.service";

@Injectable()
export class TagsService {

  private headers = new Headers({'Content-Type': 'application/json', 'Authorization': AuthService.getToken()});
  private usersUrl = 'api/tags';

  constructor(private http: Http) { }

  getTags(): Promise<Tag[]> {
    return this.http.get(this.usersUrl, {headers: this.headers})
      .toPromise().then(response => response.json() as Tag[])
      .catch(this.handleError);
  }

  createTag(tag: Tag): Promise<Tag> {
    return this.http.post(this.usersUrl, JSON.stringify(tag), {headers: this.headers})
      .toPromise().then(response => response.json() as Tag)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
