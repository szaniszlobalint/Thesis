import {Component, Input, OnInit} from '@angular/core';
import { Output, EventEmitter } from '@angular/core';
import {RedPair} from "../models/redpair";

@Component({
  selector: 'app-pair-handler',
  templateUrl: './pair-handler.component.html',
  styleUrls: ['./pair-handler.component.css']
})
export class PairHandlerComponent implements OnInit {
  aRedModel: any = [];
  bRedModel: any = [];

  objectPair: RedPair = {
    aid: 0,
    bid: 0,
    id: 0
  }

  @Input() objectsForAList: any;
  @Input() objectsForBList: any;
  @Input() currentPairs: any;

  @Output() objectsToConnect = new EventEmitter<any>();
  @Output() objectsToDelete = new EventEmitter<any>();
  @Output() refreshObjects = new EventEmitter<any>();

  constructor() { }

  ngOnInit(): void {
  }

  aCheckIsDisabled(num: number) {
    let res = false;
    for(let i = 0; i < this.currentPairs.length; i++) {
      if (this.currentPairs[i].aid === num) {
        res = true;
      }
    }
    return res;
  }

  bCheckIsDisabled(num: number) {
    let res = false;
    for(let i = 0; i < this.currentPairs.length; i++) {
      if (this.currentPairs[i].bid === num) {
        res = true;
      }
    }
    return res;
  }

  pairFinder(aId: number | undefined): void {
    if(aId === undefined) {
      return;
    }
    for(let i = 0; i < this.currentPairs.length; i++) {
      if (this.currentPairs[i].aid === aId) {
        this.bRedModel = [this.currentPairs[i].bid];
        return;
      }
      else if(this.bCheckIsDisabled(this.bRedModel[0])) {
        this.bRedModel = [];
      }
    }
    if(!this.aCheckIsDisabled(this.aRedModel[0])) {
      this.bRedModel = [];
    }
  }

  connectObjects(aId: number, bId: number) {
    this.objectPair.aid = aId;
    this.objectPair.bid = bId;
    this.objectsToConnect.emit(this.objectPair);
  }

  deleteObjects(aId: number, bId: number) {
    this.objectPair.aid = aId;
    this.objectPair.bid = bId;
    this.bRedModel = [];
    this.objectsToDelete.emit(this.objectPair);
  }

  objectsRefresher() {
    this.refreshObjects.emit();
  }

}
