///<reference path="../../../node_modules/@angular/core/src/metadata/directives.d.ts"/>
import { Component, OnInit } from '@angular/core';
import {Rooms} from '../dtos/rooms';
import {MiddleContainerComponent} from '../middle-container/middle-container.component';
import {ValuesService} from '../services/values.service';
import {ActivatedRoute} from '@angular/router';
import {RoomsService} from '../services/rooms.service';

@Component({
  selector: 'app-check-room',
  templateUrl: './check-room.component.html',
  styleUrls: ['./check-room.component.scss']
})
export class CheckRoomComponent implements OnInit {
  routeID = '';
  room: Rooms = new Rooms();
  constructor(private valuesSerive: ValuesService, private _route: ActivatedRoute, private roomService: RoomsService) { }

  ngOnInit() {
     this.routeID = this._route.snapshot.paramMap.get('id');
     this.findRoom(this.routeID);
  }
  findRoom(routeID): void {
    this.roomService.searchRoom(routeID).subscribe(
      (value) => {
        if (value != null) {
          this.room = value;
        } else {
          alert('Room Not Found !');
        }
      }
    );
  }
}
