import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';

import { Copypasta } from "../model/copypasta";

@Injectable()
export class CopypastaService {

  private headers = new Headers({'Content-Type': 'application/json'});
  private pastasUrl = 'api/pastas/';

  constructor(private http: Http) { }

  getAllCopypastas(): Promise<Copypasta[]> {
    return this.http.get(this.pastasUrl)
      .toPromise().then(response => response.json() as Copypasta[])
      .catch(this.handleError);
  }

  saveCopypasta(copypasta: Copypasta) {
    this.http.post(this.pastasUrl + copypasta.id.toString(), JSON.stringify(copypasta), {headers: this.headers})
      .toPromise().catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
