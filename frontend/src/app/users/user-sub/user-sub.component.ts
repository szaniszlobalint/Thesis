import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-user-sub',
  templateUrl: './user-sub.component.html',
  styleUrls: ['./user-sub.component.css']
})
export class UserSubComponent implements OnInit {

  @Input() vmi = "asd";

  @Output() newItemEvent = new EventEmitter<string>();

  constructor() { }

  ngOnInit(): void {
  }

  addNewItem(value: string) {
    this.newItemEvent.emit(value);
  }

}
