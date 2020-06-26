import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {RoomsService} from '../services/rooms.service';
import {Rooms} from '../dtos/rooms';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  constructor(private _route: ActivatedRoute, private roomService: RoomsService) { }
  routeID;
  room: Rooms = new Rooms();
  suggestList: Array<Rooms> = [];
  d1;
  d2;
  count = 0;
  ngOnInit() {
    this.routeID = this._route.snapshot.paramMap.get('id');
    this.d1 = this._route.snapshot.paramMap.get('d1');
    this.d2 = this._route.snapshot.paramMap.get('d2');
    this.loadRoom(this.routeID);
  }
  loadRoom(routeID): void {
    this.roomService.searchRoom(routeID).subscribe(
      (value) => {
        if (value != null) {
          this.room = value;
          this.roomService.searchRoomByType(this.room.type).subscribe(
            (type) => {
              this.suggestList = type;
            }
          );
        } else {
          alert('Room Not Found !');
        }
      }
    );
  }
  payment(): void {
  }
  Food(food, event): void {
    if (food === 'B') {
      this.count++;
      if (this.count === 1) {
        this.room.price  = this.room.price + 350;
      } else {
        this.room.price  = this.room.price - 350;
        this.count = 0;
      }
    }
    if (food === 'L') {
      if (event.target.checked) {
        this.room.price  = this.room.price + 450;
      } else {
        this.room.price  = this.room.price - 450;
      }
    }
    if (food === 'D') {
      if (event.target.checked) {
        this.room.price  = this.room.price + 500;
      } else {
        this.room.price  = this.room.price - 500;
      }
    }
  }
}
