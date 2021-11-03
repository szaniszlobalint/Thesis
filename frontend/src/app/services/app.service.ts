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

  getAllRedUsers(){
    return this.http.get<RedUser[]>('http://localhost:8080/getallsystemusers').toPromise();
  }

  getRedAUsers(){
    return this.http.get<RedUser[]>('http://localhost:8080/getallredAusers').toPromise();
  }

  getRedBUsers(){
    return this.http.get<RedUser[]>('http://localhost:8080/getallredBusers').toPromise();
  }

  connectUsers(AID: number, BID: number){
    return this.http.post('http://localhost:8080/savesystemuserpair', {auserid: AID,buserid: BID});
  }

  fillUserDatabase(users: RedUser[]){
    return this.http.post('http://localhost:8080/updatesystemuser', users);
  }

  Aconnectioncheck(auserid: number, buserid: number){
    return this.http.post<Object>('http://localhost:8080/checksystemuserpairs', {auserid,buserid}).toPromise();
}


}
