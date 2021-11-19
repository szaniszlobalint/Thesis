import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {AppService} from "../services/app.service";
import {RedSystem} from "../models/redsystem";

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

  @Output() sendSystems = new EventEmitter<string[]>();

  constructor(private appService: AppService) { }

  ngOnInit(): void {
    this.getSystems();
  }

  async getSystems() {
    this.systemArray = await this.appService.getSystems();
  }

  pairSystems(firstSystem: string, secondSystem: string) {
    this.systemsForNav[0] = firstSystem;
    this.systemsForNav[1] = secondSystem;
    this.sendSystems.emit(this.systemsForNav);

  }
}
