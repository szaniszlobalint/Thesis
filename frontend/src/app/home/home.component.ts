import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {AppService} from "../services/app.service";
import {RedSystem} from "../models/redsystem";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  firstSystem: any = [];
  secondSystem: any = [];

  systemArray: RedSystem[] = [];
  systemsForNav: string[] = [];
  chosenSystem: number = 0;

  constructor(private appService: AppService) { }

  ngOnInit(): void {
    this.getSystems();
  }

  async getSystems() {
    this.systemArray = await this.appService.getSystems();
  }

  pairSystems(chosenSystem: number) {
    if(chosenSystem === 1){
      this.systemsForNav[0] = 'A Redmine';
      this.systemsForNav[1] = 'B Redmine';
      this.appService.sendSystems(this.systemsForNav);
    }
  }
}
