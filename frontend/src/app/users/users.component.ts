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
      if(user.systemid === 1 && user.login !== '') {
        if(this.aRedUsers.find(aUser => aUser.login === user.login && aUser.systemid === user.systemid) === undefined){
          this.aRedUsers.push(user);
        }
      } else if(user.systemid === 2 && user.login !== '') {
        if(this.bRedUsers.find(bUser => bUser.login === user.login && bUser.systemid === user.systemid) === undefined){
          this.bRedUsers.push(user);
        }
      }
    });
  }

  async getUserPairs() {
    this.currentPairs = await this.appService.getUserPairs();
  }


  async connectSelectedUsers(pair: RedPair) {
      await this.appService.connectUsers(pair.aid, pair.bid);
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



  async deleteConnection(pair: RedPair) {
    await this.appService.deleteUserConnection(pair.aid, pair.bid);
    await this.getUserPairs();
    this.openSnackBar('Successful deletion!', 'Ok');
  }

}
