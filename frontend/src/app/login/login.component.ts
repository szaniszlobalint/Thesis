import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {User} from "../user";
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
    name: '',
    password: '',
    mail: ''
  };

  userForm = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });

  loginUser() {
    this.user.name = this.userForm.value.username;
    this.user.password = this.userForm.value.password;
    this.appService.loginUser(this.user).subscribe(user => {
      //localStorage.setItem('jwt',user.accesToken!);

      this.router.navigateByUrl('/home');
      console.log("asd");
    }, error => {
      console.error('Wrong Username or Password!');
    });
  }

  getUser(){
    this.appService.getUsers().subscribe(user => console.log(user));
  }


}
