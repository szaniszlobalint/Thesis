import { Component, OnInit } from '@angular/core';
import {AppService} from "../services/app.service";
import {User} from "../models/user";
import {RedUser} from "../models/reduser";
import {RedUserPair} from "../models/reduserpair";
import {MatSnackBar} from "@angular/material/snack-bar";


@Component({
  selector: 'app-home',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {


  Aredusers: RedUser[] = [];
  Bredusers: RedUser[] = [];
  allRedUsers: RedUser[] = [];
  //redUserSelected: RedUser | null = null;
  currentPair : RedUserPair = {
    auserid: 0,
    buserid: 0,
    id: 0
  }

  constructor(private appService: AppService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.getAllRedAUsers();
    this.getAllRedBUsers();
    this.getAllRedUsers();
  }

 async getAllRedAUsers(){
    await this.appService.getRedAUsers().then(users => this.Aredusers = users);
    for(let i=0; i < this.Aredusers.length; i++){
      this.Aredusers[i].systemid=1;
      this.Aredusers[i].redmineid=this.Aredusers[i].id;
      this.Aredusers[i].id=undefined;
    }
    this.fillUserDatabase(this.Aredusers);
  }

  async getAllRedBUsers(){
    await this.appService.getRedBUsers().then(users => this.Bredusers = users);
    for(let i=0; i < this.Bredusers.length; i++){
      this.Bredusers[i].systemid=2;
      this.Bredusers[i].redmineid=this.Bredusers[i].id;
      this.Bredusers[i].id=undefined;
    }
    this.fillUserDatabase(this.Bredusers);
  }

  getAllRedUsers(){
    this.appService.getAllRedUsers().then(users => this.allRedUsers = users);
  }

  connectUsers(AID: number, BID: number){
    if(AID!==null && BID!==null){
      this.appService.connectUsers(AID,BID).then();
    }
  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action);
  }

  fillUserDatabase(users: RedUser[]){
    this.appService.fillUserDatabase(users).then();
  }

  refreshUsers(){
    this.appService.refreshUsers()
  }



  async connectionChecker(auserid: number, buserid: number){
    await this.appService.Aconnectioncheck(auserid, buserid).then(
      pair => this.currentPair = pair
    )
    console.log(this.currentPair);
  }

  // isBreduserselected(id: number | undefined) {
  //   if (!this.redUserSelected) {
  //     return false;
  //   }
  //   return this.redUserSelected.id === id;
  // }
}
