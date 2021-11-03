import { Component, OnInit } from '@angular/core';
import {AppService} from "../services/app.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {User} from "../models/user";
import {Router} from "@angular/router";

@Component({
  selector: 'app-test',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private appService: AppService, private router: Router) { }

  ngOnInit(): void {
  }

  user: User= {
    id:0,
    username: '',
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
      //localStorage.setItem('jwt',user.accesToken!);

      if(user != null) {
        this.router.navigateByUrl('/home');
      }
      else{
        console.log("something went wrong!")
      }
    }, error => {
      console.error('Wrong Username or Password!');
    });
  }

  getUser(){
    this.appService.getUsers().subscribe(user => console.log(user));
  }


}
