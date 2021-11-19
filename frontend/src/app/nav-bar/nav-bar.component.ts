import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  firstSystem: string = '';
  secondSystem: string = '';

  constructor() { }

  ngOnInit(): void {
  }

  fillSystemNames(system: string[]) {
    this.firstSystem = system[0];
    this.secondSystem = system[1];
  }

}
