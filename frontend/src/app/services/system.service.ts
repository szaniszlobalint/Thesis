import { Injectable } from '@angular/core';
import {Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SystemService {

  private systemPair = new Subject<number>();

  constructor() { }

  getChosenPair(pair?: number) {
    if(pair === undefined){
      this.systemPair.next(1);
      return this.systemPair.asObservable();
    }
    return this.systemPair.asObservable();
  }


  setSystems(pairnumber: number) {
    this.systemPair.next(pairnumber);
  }
}
