import {Component, Input, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {AppService} from "../services/app.service";
import {RedSystem} from "../models/redsystem";
import {SystemService} from "../services/system.service";

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  firstSystem: string = '';
  secondSystem: string = '';

  constructor(private appService: AppService, private systemService: SystemService) { }

  ngOnInit(): void {
    this.systemService.getMessage().subscribe(systems => {this.firstSystem = systems[0]; this.secondSystem = systems[1]} )
  }

}
