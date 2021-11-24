import {Component, Input, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {AppService} from "../services/app.service";
import {RedSystem} from "../models/redsystem";
import {SystemService} from "../services/system.service";
import {RedPair} from "../models/redpair";

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {


  currentPairs: RedPair[] = [];
  systemArray: RedSystem[] = [];
  chosenPair: number = 0;

  firstSystem: string = '';
  secondSystem: string = '';

  constructor(private appService: AppService, private systemService: SystemService) { }

  ngOnInit(): void {
    this.getSystems();
    this.getSystemPairs();
    this.systemService.getChosenPair(undefined).subscribe(pair => {this.chosenPair = pair; console.log(this.chosenPair)})
    //this.firstSystem = this.systemArray[this.currentPairs[this.chosenPair-1].aid].name;
  }

  async getSystems() {
    this.systemArray = await this.appService.getSystems();
    let arrayHelper: RedSystem[] = [];
    this.systemArray.forEach(system => arrayHelper[system.id!] = system);
    this.systemArray = arrayHelper;

    //this.systemArray.sort((a,b) => (a.id! > b.id!) ? 1 : -1);
  }

  async getSystemPairs() {
    this.currentPairs = await this.appService.getSystemPairs();
  }

}
