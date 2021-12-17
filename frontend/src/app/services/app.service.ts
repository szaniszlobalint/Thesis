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
    return this.http.post<User>('rest/login', user);
  }

  getAllRedUsers() {
    return this.http.get<RedUser[]>('rest/getallsystemusers').toPromise();
  }

  connectUsers(AID: number, BID: number) {
    return this.http.post('rest/savesystemuserpair', {aid: AID, bid: BID}).toPromise();
  }

  getUserPairs() {
    return this.http.get<RedPair[]>('rest/systemuserpair').toPromise();
  }

  deleteUserConnection(auserid: number, buserid: number) {
    return this.http.post<RedPair>('rest/deletesystemuserpair', {aid: auserid, bid: buserid}).toPromise();
  }

  refreshUsers() {
    return this.http.get<RedUser[]>('rest/refreshusers').toPromise();
  }

  getSystems() {
    return this.http.get<RedSystem[]>('rest/getRedSystems').toPromise();
  }

  getSystemPairs() {
    return this.http.get<RedPair[]>('rest/getsystempairs').toPromise();
  }

  async getAllRedProjects() {
    return this.http.get<RedProject[]>('rest/getallprojects').toPromise();
  }

  async getProjectPairs() {
    return this.http.get<RedPair[]>('rest/getprojectpairs').toPromise();
  }

  async connectProjects(aid: number, bid: number) {
    return this.http.post('rest/saveprojectpair', {aid: aid,bid: bid}).toPromise();
  }

  async refreshProjects() {
    return this.http.get<RedProject[]>('rest/refreshprojects').toPromise();
  }

  async deleteProjectConnection(aid: number, bid: number) {
    return this.http.post<RedPair>('rest/deleteprojectpair', {aid: aid, bid: bid}).toPromise();
  }

  synchronizeIssues() {
    return this.http.get('rest/synchronizeissues/1', {responseType: 'text'}).toPromise();
  }
}
