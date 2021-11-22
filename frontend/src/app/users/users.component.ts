import { Component, OnInit } from '@angular/core';
import {AppService} from "../services/app.service";
import {RedUser} from "../models/reduser";
import {RedPair} from "../models/redpair";
import {MatSnackBar} from "@angular/material/snack-bar";


@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  allRedUsers: RedUser[] = [];
  aRedUsers: RedUser[] = [];
  bRedUsers: RedUser[] = [];

  aRedUserModel: any = [];
  bRedUserModel: any = [];

  currentPairs : RedPair[] = [];


  constructor(private appService: AppService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.getAllRedUsers();
    this.getUserPairs();
  }

  async getAllRedUsers() {
    this.allRedUsers = await this.appService.getAllRedUsers();
    this.allRedUsers.forEach(user => user.display = user.login);
    this.allRedUsers.forEach(user => {
      if(user.systemid === 1) {
        this.aRedUsers.push(user);
      } else {
        this.bRedUsers.push(user);
      }
    });
  }

  async getUserPairs() {
    this.currentPairs = await this.appService.getUserPairs();
  }


  async connectSelectedUsers(pair: RedPair) {
      await this.appService.connectUsers(pair.aId, pair.bId);
      await this.getUserPairs();
      this.openSnackBar('Successful connection!', 'Ok');
  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action,{
      duration:  2000
    });

  }

  async refreshUsers() {
    await this.appService.refreshUsers();
    await this.getAllRedUsers();
    this.openSnackBar("Users refreshed!", "Ok");
  }



  async deleteConnection(auserid: number, buserid: number) {
    await this.appService.deleteUserConnection(auserid, buserid);
    await this.getUserPairs();
    this.bRedUserModel = [];
    this.openSnackBar('Successful deletion!', 'Ok');
  }

}
