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

  info: {
    systemPairs: RedPair[],
    systemArray: RedSystem[],
    selectedPair: RedPair | undefined
  } = {
    systemPairs: [],
    systemArray: [],
    selectedPair: undefined
  };

  constructor(private appService: AppService, private systemService: SystemService) { }

  ngOnInit(): void {
    this.info = this.systemService.getSystemInfo();
  }

  printSelectedSystemPair() {
    let value: string | undefined;
    if(this.info.selectedPair === undefined) {
      value = this.info.systemArray.find(item => item.id === this.info.systemPairs[0].aid)!.name + " - "
      + this.info.systemArray.find(item => item.id === this.info.systemPairs[0].bid)!.name;
    }else {
      value = this.info.systemArray.find(item => item.id === this.info.selectedPair!.aid)!.name + " - "
        + this.info.systemArray.find(item => item.id === this.info.selectedPair!.bid)!.name;
    }
    return value;
  }

}
