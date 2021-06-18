import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  baseURL: string = "http://localhost:8080/api-login";

  constructor(private http: HttpClient) { }

  isValidLogin(username, password): Observable<any>{
    const headers = {'Access-Control-Allow-Origin': '*'}  
    const body=JSON.stringify({username: username, password: password});
    console.log(body)
    return this.http.post(this.baseURL, body,{'headers':headers})
  }
}
