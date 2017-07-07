import {Injectable} from "@angular/core";
import {Headers, Http} from "@angular/http";
import "rxjs/add/operator/toPromise";

import {Copypasta} from "../model/copypasta";
import {Rating} from "../model/rating";
import {Comment} from "../model/comment";
import {AuthService} from "./auth.service";

@Injectable()
export class CopypastaService {

  private headers = new Headers({'Content-Type': 'application/json', 'Authorization': AuthService.getToken()});
  private pastasUrl = 'api/pastas/';

  constructor(private http: Http) { }

  getAllCopypastas(): Promise<Copypasta[]> {
    return this.http.get(this.pastasUrl, {headers: this.headers})
      .toPromise().then(response => response.json() as Copypasta[])
      .catch(this.handleError);
  }

  getByTag(tagId: number): Promise<Copypasta[]> {
    return this.http.get(this.pastasUrl + 'tag/' + tagId, {headers: this.headers})
      .toPromise().then(response => response.json() as Copypasta[])
      .catch(this.handleError);
  }


  addComment(comment: Comment, pastaId: number): Promise<Comment> {
    return this.http.post(this.pastasUrl + pastaId.toString() + "/comment", JSON.stringify(comment), {headers: this.headers})
      .toPromise().then(response => response.json() as Comment)
      .catch(this.handleError);
  }

  addRating(rating: Rating, pastaId: number): Promise<Rating> {
    return this.http.post(this.pastasUrl + pastaId.toString() + "/rating", JSON.stringify(rating), {headers: this.headers})
      .toPromise().then(response => response.json() as Rating)
      .catch(this.handleError);
  }

  createCopypasta(copypasta: Copypasta) {
    this.http.post(this.pastasUrl, JSON.stringify(copypasta), {headers: this.headers})
      .toPromise().catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
