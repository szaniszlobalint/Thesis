import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {AppService} from "../services/app.service";
import {RedSystem} from "../models/redsystem";
import {Subscription} from "rxjs";
import {SystemService} from "../services/system.service";
import {RedPair} from "../models/redpair";
import {MatSnackBar} from "@angular/material/snack-bar";

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
  chosenSystem: number = 0;

  constructor(private appService: AppService, private systemService: SystemService, private _snackBar: MatSnackBar) { }

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
  }

  async getSystemPairs() {
    this.currentPairs = await this.appService.getSystemPairs();
  }

  pairSystems(chosenSystem: number) {
      this.systemService.setSelectedSystem(chosenSystem);
  }

  async synchronizeIssues() {
    await this.appService.synchronizeIssues();
    this.openSnackBar('Successful synchronization!', 'Ok');
  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action,{
      duration:  2000
    });

  }
}
