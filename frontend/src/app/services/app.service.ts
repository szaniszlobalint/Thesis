import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {User} from "../models/user";
import {RedUser} from "../models/reduser";
import {RedUserPair} from "../models/reduserpair";

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

  getAllRedUsers(){
    return this.http.get<RedUser[]>('http://localhost:8080/getallsystemusers').toPromise();
  }

  getRedAUsers(){
    return this.http.get<RedUser[]>('http://localhost:8080/getallredusers?id=1').toPromise();
  }
  getRedUsers(id: number){
    return this.http.get<RedUser[]>('http://localhost:8080/getallredusers?id=' + id).toPromise();
  }

  getRedBUsers(){
    return this.http.get<RedUser[]>('http://localhost:8080/getallredusers?id=2').toPromise();
  }

  connectUsers(AID: number, BID: number){
    return this.http.post('http://localhost:8080/savesystemuserpair', {auserid: AID,buserid: BID}).toPromise();
  }

  fillUserDatabase(users: RedUser[]){
    return this.http.post('http://localhost:8080/updatesystemuser', users).toPromise();
  }

  Aconnectioncheck(auserid: number, buserid: number){
    return this.http.post<RedUserPair>('http://localhost:8080/checksystemuserpairs', {auserid,buserid}).toPromise();
}

  refreshUsers(){
    return this.http.get<RedUser[]>('http://localhost:8080/refresh').toPromise();
  }

}
