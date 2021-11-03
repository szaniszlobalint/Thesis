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


  Aredusers: RedUser[] = [];
  Bredusers: RedUser[] = [];
  allRedUsers: RedUser[] = [];

  constructor(private appService: AppService) { }

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
    this.appService.connectUsers(AID,BID).subscribe();
  }



  fillUserDatabase(users: RedUser[]){
    this.appService.fillUserDatabase(users).subscribe();
  }


  blablatUsers(asd: any, basd: any) {
    console.log(asd,basd);
  }

  connectionChecker(auserid: number, buserid: number){
    this.appService.Aconnectioncheck(auserid, buserid).then(pair => console.log(pair));
  }
}
