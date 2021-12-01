import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {User} from "../models/user";
import {RedUser} from "../models/reduser";
import {RedPair} from "../models/redpair";
import {RedSystem} from "../models/redsystem";
import {RedProject} from "../models/redproject";

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http: HttpClient) { }

  loginUser(user: User) {
    return this.http.post<User>('http://localhost:8080/login', user);
  }

  getAllRedUsers() {
    return this.http.get<RedUser[]>('http://localhost:8080/getallsystemusers').toPromise();
  }

  connectUsers(AID: number, BID: number) {
    return this.http.post('http://localhost:8080/savesystemuserpair', {aid: AID, bid: BID}).toPromise();
  }

  getUserPairs() {
    return this.http.get<RedPair[]>('http://localhost:8080/systemuserpair').toPromise();
  }

  deleteUserConnection(auserid: number, buserid: number) {
    return this.http.post<RedPair>('http://localhost:8080/deletesystemuserpair', {aid: auserid, bid: buserid}).toPromise();
  }

  refreshUsers() {
    return this.http.get<RedUser[]>('http://localhost:8080/refreshusers').toPromise();
  }

  getSystems() {
    return this.http.get<RedSystem[]>('http://localhost:8080/getRedSystems').toPromise();
  }

  getSystemPairs() {
    return this.http.get<RedPair[]>('http://localhost:8080/getsystempairs').toPromise();
  }

  async getAllRedProjects() {
    return this.http.get<RedProject[]>('http://localhost:8080/getallprojects').toPromise();
  }

  async getProjectPairs() {
    return this.http.get<RedPair[]>('http://localhost:8080/getprojectpairs').toPromise();
  }

  async connectProjects(aid: number, bid: number) {
    return this.http.post('http://localhost:8080/saveprojectpair', {aid: aid,bid: bid}).toPromise();
  }

  async refreshProjects() {
    return this.http.get<RedProject[]>('http://localhost:8080/refreshprojects').toPromise();
  }

  async deleteProjectConnection(aid: number, bid: number) {
    return this.http.post<RedPair>('http://localhost:8080/deleteprojectpair', {aid: aid, bid: bid}).toPromise();
  }

  synchronizeIssues() {
    return this.http.get<string>('http://localhost:8080/synchronizeissues').toPromise();
  }
}
