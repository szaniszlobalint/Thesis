import {Component, Input, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {AppService} from "../services/app.service";
import {RedSystem} from "../models/redsystem";

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  subscription: Subscription | undefined;

  firstSystem: string = '';
  secondSystem: string = '';

  constructor(private appService: AppService) { }

  ngOnInit(): void {
    this.subscription = this.appService.getMessage().subscribe(systems => {this.firstSystem = systems[0]; this.secondSystem = systems[1]} )
  }

}
