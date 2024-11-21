import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private baseUrl = 'http://localhost:8085/ims/api/dealers';

  constructor( private http:HttpClient ) { }

  getDealersList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  login(dealer:any):Observable<any>
  {
    return this.http.post(`http://localhost:8085/ims/api/dealer`,dealer)
  }

  saveDealer(dealer: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, dealer);
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }
 
  logOut() {
    sessionStorage.removeItem('username')
  }
}
