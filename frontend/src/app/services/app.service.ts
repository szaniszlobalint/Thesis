import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {User} from "../models/user";
import {RedUser} from "../models/reduser";
import {RedUserPair} from "../models/reduserpair";
import {RedSystem} from "../models/redsystem";
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  private systemSource = new Subject<string[]>();

  constructor(private http: HttpClient) { }

  loginUser(user: User) {
    return this.http.post<User>('http://localhost:8080/login', user);
  }

  getAllRedUsers() {
    return this.http.get<RedUser[]>('http://localhost:8080/getallsystemusers').toPromise();
  }

  connectUsers(AID: number, BID: number){
    return this.http.post('http://localhost:8080/savesystemuserpair', {auserid: AID,buserid: BID}).toPromise();
  }

  getUserPairs() {
    return this.http.get<RedUserPair[]>('http://localhost:8080/systemuserpair').toPromise();
  }

  deleteConnection(auserid: number, buserid: number) {
    return this.http.post<RedUserPair>('http://localhost:8080/deletesystemuserpair', {auserid,buserid}).toPromise();
  }

  refreshUsers() {
    return this.http.get<RedUser[]>('http://localhost:8080/refresh').toPromise();
  }

  getSystems() {
    return this.http.get<RedSystem[]>('http://localhost:8080/getRedSystems').toPromise();
  }

  getMessage() {
    return this.systemSource.asObservable();
  }

  sendSystems(systems: string[]) {
    this.systemSource.next(systems);
  }

}
