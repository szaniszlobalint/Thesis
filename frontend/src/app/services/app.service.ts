import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {User} from "../models/user";
import {RedUser} from "../models/reduser";

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
    return this.http.get<User[]>('http://localhost:8080/getallusers');
  }

  getRedAUsers(){
    return this.http.get<RedUser[]>('http://localhost:8080/getallredAusers');
  }

  getRedBUsers(){
    return this.http.get<RedUser[]>('http://localhost:8080/getallredBusers');
  }

  connectUsers(AID: number, BID: number){
    return this.http.post('http://localhost:8080/savesystemuserpair', {AID: AID,BID: BID});
  }

  fillUserDatabase(users: RedUser[]){
    return this.http.post('http://localhost:8080/savesystemuserpair', users);
  }


}
