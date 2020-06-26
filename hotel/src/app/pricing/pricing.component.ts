import { Component, OnInit } from '@angular/core';
import {RoomsService} from '../services/rooms.service';
import {Rooms} from '../dtos/rooms';

@Component({
  selector: 'app-pricing',
  templateUrl: './pricing.component.html',
  styleUrls: ['./pricing.component.scss']
})
export class PricingComponent implements OnInit {
  roomList: Array<Rooms>;
  constructor(private roomService: RoomsService) { }

  ngOnInit() {
    this.loadRooms();
  }

  loadRooms() {
    this.roomService.getAllIRooms().subscribe(
      (value) => {
            this.roomList = value;
      }
    );
  }

}
