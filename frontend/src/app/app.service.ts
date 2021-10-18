import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {User} from "./user";

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http: HttpClient) { }

  testMethod(){
    return this.http.get('http://localhost:8080/test', {responseType: 'text'});
  }

  getUsers(){
    return this.http.get<User>('http://localhost:8080/users');
  }


}
