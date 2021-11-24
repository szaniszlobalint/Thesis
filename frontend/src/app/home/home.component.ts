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
    let arrayHelper: RedSystem[] = [];
    this.systemArray.forEach(system => arrayHelper[system.id!] = system);
    this.systemArray = arrayHelper;

    //this.systemArray.sort((a,b) => (a.id! > b.id!) ? 1 : -1);
    console.log(this.systemArray);
  }

  async getSystemPairs() {
    this.currentPairs = await this.appService.getSystemPairs();
  }

  pairSystems(chosenSystem: number) {
      this.systemsForNav[0] = this.systemArray[this.currentPairs[chosenSystem-1].aid].name;
      this.systemsForNav[1] = this.systemArray[this.currentPairs[chosenSystem-1].bid].name;
      this.systemService.sendSystems(this.systemsForNav);
  }
}
