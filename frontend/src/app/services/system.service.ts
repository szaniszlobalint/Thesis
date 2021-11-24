import { Injectable } from '@angular/core';
import {Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SystemService {

  private systemPair = new Subject<number>();

  constructor() { }

  getChosenPair(pair: number | undefined) {
    if(pair === undefined){
      this.systemPair.next(1);
    }
    return this.systemPair.asObservable();
  }

  getMessage() {
    return this.systemPair.asObservable();
  }

  setSystems(systems: number) {
    this.systemPair.next(systems);
  }
}
