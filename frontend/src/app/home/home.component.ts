import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {User} from "../user";

@Component({
  selector: 'app-test',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private appService: AppService) { }

  ngOnInit(): void {
  }

  user: User= {
    id:0,
    name: '',
    password: '',
    mail: ''
  };

  userForm = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });

  loginUser() {
    this.user.username = this.userForm.value.username;
    this.user.password = this.userForm.value.password;
    this.appService.loginUser(this.user).subscribe(user => {
      localStorage.setItem('jwt',user.accesToken!);
      this.router.navigateByUrl('/welcome');
      console.log(localStorage.getItem('jwt'));
    }, error => {
      console.error('Wrong Username or Password!');
    });
  }

  getUser(){
    this.appService.getUsers().subscribe(user => console.log(user));
  }


}
