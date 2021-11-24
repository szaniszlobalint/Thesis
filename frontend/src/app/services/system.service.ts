import { Injectable } from '@angular/core';
import {Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SystemService {

  private systemSource = new Subject<string[]>();

  constructor() { }

  getMessage() {
    return this.systemSource.asObservable();
  }

  sendSystems(systems: string[]) {
    this.systemSource.next(systems);
  }
}
