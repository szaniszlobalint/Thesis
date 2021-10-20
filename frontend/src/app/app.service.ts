import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {User} from "./user";

@Injectable({
  providedIn: 'root'
})
export class AppService {

  httpOptions={
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  loginUser(user: User){
    return this.http.post<User>('http://localhost:8080/login', user);
  }

  getUsers(){
    return this.http.get<User>('http://localhost:8080/users');
  }


}
