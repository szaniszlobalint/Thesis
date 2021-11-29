import { Injectable } from '@angular/core';
import {Subject} from "rxjs";
import {RedPair} from "../models/redpair";
import {RedSystem} from "../models/redsystem";
import {AppService} from "./app.service";

@Injectable({
  providedIn: 'root'
})
export class SystemService {

  private systemInfo: {
    systemPairs: RedPair[],
    systemArray: RedSystem[],
    selectedPair: RedPair | undefined
  } = {
    systemPairs: [],
    systemArray: [],
    selectedPair: undefined
  }

  private selectedSystemChangedEvent = new Subject<RedPair | undefined>();

  constructor(private appService: AppService) {
    this.initSystems();
  }

  initSystems() {
    this.appService.getSystems().then(result => {
      this.systemInfo.systemArray = result;
    });
    this.appService.getSystemPairs().then(result => {
      this.systemInfo.systemPairs = result;
    });
  }

  getSystemInfo() {
    return this.systemInfo;
  }

  getSelectedSystemSubject() {
    return this.selectedSystemChangedEvent;
  }

  setSelectedSystem(pairnumber: number) {
    this.systemInfo.selectedPair = this.systemInfo.systemPairs.find(item => item.id === pairnumber);
    this.selectedSystemChangedEvent.next(this.systemInfo.selectedPair);
  }

}
