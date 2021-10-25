import { Component, OnInit } from '@angular/core';
import {AppService} from "../services/app.service";
import {User} from "../models/user";
import {RedUser} from "../models/reduser";


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  myControl: any;
  users: User[] = [];
  Aredusers: RedUser[] = [];
  Bredusers: RedUser[] = [];

  getAllUsers(){
    this.appService.getUsers().subscribe(users => this.users = users);
  }

  getAllRedAUsers(){
    this.appService.getRedAUsers().subscribe(users => this.Aredusers = users);
  }

  getAllRedBUsers(){
    this.appService.getRedBUsers().subscribe(users => this.Bredusers = users);
  }

  connectUsers(AID: number, BID: number){
    console.log(AID,BID);
    this.appService.connectUsers(AID,BID).subscribe();
  }

  fillUserDatabase(){

  }


  constructor(private appService: AppService) { }

  ngOnInit(): void {
    this.getAllRedAUsers();
    this.getAllRedBUsers();
    this.fillUserDatabase();
  }

}
