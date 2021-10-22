import { Component, OnInit } from '@angular/core';
import {AppService} from "../services/app.service";
import {User} from "../models/user";


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  myControl: any;
  users: User[] = [];

  getAllUsers(){
    this.appService.getUsers().subscribe(user => this.users = user)
  }


  constructor(private appService: AppService) { }

  ngOnInit(): void {
    this.getAllUsers();
  }

}
