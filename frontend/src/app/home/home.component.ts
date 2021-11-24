import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {AppService} from "../services/app.service";
import {RedSystem} from "../models/redsystem";
import {Subscription} from "rxjs";
import {SystemService} from "../services/system.service";
import {RedPair} from "../models/redpair";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  firstSystem: any = [];
  secondSystem: any = [];

  currentPairs: RedPair[] = [];
  systemArray: RedSystem[] = [];
  systemsForNav: string[] = [];
  chosenSystem: number = 0;

  constructor(private appService: AppService, private systemService: SystemService) { }

  ngOnInit(): void {
    this.getSystems();
    this.getSystemPairs();
  }

  async getSystems() {
    this.systemArray = await this.appService.getSystems();
  }

  async getSystemPairs() {
    this.currentPairs = await this.appService.getSystemPairs();
    console.log(this.currentPairs);
  }

  pairSystems(chosenSystem: number) {
    if(chosenSystem === 1){
      this.systemsForNav[0] = 'A Redmine';
      this.systemsForNav[1] = 'B Redmine';
      this.systemService.sendSystems(this.systemsForNav);
    }
  }
}
