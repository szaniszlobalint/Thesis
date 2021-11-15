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

  allRedUsers: RedUser[] = [];
  aUserID: number = 0;

  aRedUserModel: any = [];
  bRedUserModel: any = [];

  currentPairs : RedUserPair[] = [];


  constructor(private appService: AppService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.getAllRedUsers();
    this.getUserPairs();
  }

  getAllRedUsers(){
    this.appService.getAllRedUsers().then(users => this.allRedUsers = users);
  }

  async getUserPairs(){
    this.currentPairs = await this.appService.getUserPairs();
    console.log(this.currentPairs);
  }

  connectSelectedUsers(AID: number, BID: number){
    console.log(this.bRedUserModel);
    //const AID = this.bRedUserModel[0].id;
    if(AID!==null && BID!==null){
      this.appService.connectUsers(AID,this.bRedUserModel[0]).then();
    }
  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action,{
      duration:  2000
    });

  }

  async refreshUsers(){
    await this.appService.refreshUsers();
    this.getAllRedUsers();
  }


  // async connectionChecker(auserid: number, buserid: number){
  //   this.currentPair = await this.appService.connectionChecker(auserid, buserid);
  //   if(this.currentPair?.buserid !== null && this.currentPair?.buserid !== undefined
  //     && this.currentPair?.auserid !== null && this.currentPair?.auserid !== undefined) {
  //     this.bRedUserModel = [this.currentPair.buserid];
  //     this.aRedUserModel = [this.currentPair.auserid];
  //   }
  //
  //   console.log(this.currentPair);
  //   console.log(this.bRedUserModel);
  // }

  deleteConnection(auserid: number, buserid: number) {
    this.appService.deleteConnection(auserid, buserid).then();
  }

  checkIsDisabled(num: number){
    let res = false;
    if(this.currentPairs.find(x => x.buserid===num)!==null){
      res = true;
    }
    return res;
  }

}
