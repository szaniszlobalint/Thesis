import { Component, OnInit } from '@angular/core';
import {AppService} from "../services/app.service";
import {User} from "../models/user";
import {RedUser} from "../models/reduser";
import {RedUserPair} from "../models/reduserpair";
import {MatSnackBar} from "@angular/material/snack-bar";
import {interval, Subscription} from "rxjs";


@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  value = 0;
  //loading = false;

  allRedUsers: RedUser[] = [];

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
  }


  async connectSelectedUsers(AID: number, BID: number){
    console.log(this.bRedUserModel);
      if(AID!==null && BID!==null){
      await this.appService.connectUsers(this.aRedUserModel[0],this.bRedUserModel[0]);
      await this.getUserPairs();
      this.openSnackBar('Successful connection!', 'Ok');
    }
  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action,{
      duration:  2000
    });

  }

  async refreshUsers(){
   // this.loading = true;
    await this.appService.refreshUsers();
    await this.getAllRedUsers();
    this.openSnackBar("Users refreshed!", "Ok");
   // this.loading = false;
  }

  pairFinder(aId: number | undefined): void{
    if(aId === undefined) {
      return;
    }
    for(let i = 0; i < this.currentPairs.length; i++) {
      if (this.currentPairs[i].auserid === aId) {
        this.bRedUserModel = [this.currentPairs[i].buserid];
        return;
      }
      else if(this.bCheckIsDisabled(this.bRedUserModel[0])) {
        this.bRedUserModel = [];
      }
    }
    if(!this.aCheckIsDisabled(this.aRedUserModel[0])) {
      this.bRedUserModel = [];
    }
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

  async deleteConnection(auserid: number, buserid: number) {
    await this.appService.deleteConnection(auserid, buserid);
    await this.getUserPairs();
    this.bRedUserModel = [];
    this.openSnackBar('Successful deletion!', 'Ok');
  }

  aCheckIsDisabled(num: number){
    let res = false;
    for(let i = 0; i < this.currentPairs.length; i++) {
      if (this.currentPairs[i].auserid === num) {
        res = true;
      }
    }
    return res;
  }

  bCheckIsDisabled(num: number){
    let res = false;
    for(let i = 0; i < this.currentPairs.length; i++) {
      if (this.currentPairs[i].buserid === num) {
        res = true;
      }
    }
    return res;
  }

  addItem(newItem: string) {
    console.log(newItem + ' Received');
  }



}
