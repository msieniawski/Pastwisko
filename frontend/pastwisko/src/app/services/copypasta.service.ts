import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';

import { Copypasta } from "../model/copypasta";

@Injectable()
export class CopypastaService {

  private pastasUrl = '/pastas';

  constructor(private http: Http) { }

  getCopypastas(): Promise<Copypasta[]> {
    return this.http.get(this.pastasUrl)
      .toPromise()
      .then(response => response.json().data as Copypasta[])
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}
