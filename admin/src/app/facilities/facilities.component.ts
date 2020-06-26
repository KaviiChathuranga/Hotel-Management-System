import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Facilities} from '../dtos/facilities';
import {Rooms} from '../dtos/rooms';
import {RoomsService} from '../services/rooms.service';
import {NgForm} from '@angular/forms';
import {Facilityservice} from '../services/facility.service';
import {$} from '../../../node_modules/jquery';
import {RoomsServiceFacility} from '../services/roomFacility.service';
import {RoomFacility} from '../dtos/roomFacility';

@Component({
  selector: 'app-facilities',
  templateUrl: './facilities.component.html',
  styleUrls: ['./facilities.component.css']
})
export class FacilitiesComponent implements OnInit {
  selectedFacility: Facilities = new Facilities();
  selectedrooms: Rooms = new Rooms() ;
  roomFacility: RoomFacility = new RoomFacility();
  facility: Facilities = new Facilities();
  facilityList: Array<Facilities> = [];
  facilityList1: Array<Facilities> = [];
  roomCode = 0;
  @ViewChild('frmrooms') frmrooms: NgForm;
  constructor(private roomService: RoomsService,
              private elem: ElementRef,
              private facilityService: Facilityservice,
              private room_facility: RoomsServiceFacility) { }

  ngOnInit() {
    this.getAllFacility();
    this.room_facility.getTotalRooms().subscribe(
      (val) => {
        this.roomCode = val + 1;
        // console.log(val);
      }
    );
  }
  searchRoom(): void {
    this.selectedrooms.id = this.elem.nativeElement.querySelector('#RoomID').value;
    this.roomService.searchRoom(this.selectedrooms.id).subscribe(
      (result) => {
        if (result != null) {
          this.selectedrooms = result;
        } else {
          alert('Room ID Not Found!');
          this.clear();
        }
      }
    );
  }
  getAllFacility(): void {
    this.facilityService.getAllFacility().subscribe(
      value => {
        this.facilityList = value;
      }
    );
  }
  clear(): void {
    this.selectedrooms = null;
    this.facilityList = null;
  }

  selectRoom(facility, event): void {
    if ( event.target.checked ) {
      this.selectedrooms.price += facility.price;
      this.facilityList1.push(facility);
    } else {
      this.selectedrooms.price -= facility.price;
    }
  }

  saveRoomFacilities(): void {
    this.roomFacility.id = this.roomCode;
    // console.log(this.roomFacility.id);
    this.roomFacility.roomDto = this.selectedrooms;
    this.roomFacility.dtolist = this.facilityList1;
      this.room_facility.saveRoomsFacility(this.roomFacility).subscribe(
        (value) => {
          if (value) {
            alert('Facilities Attached To Room');
            // this.roomFacility.dtolist = null;
            // this.roomFacility.roomDto = null;
          } else {
            alert('Facilities Attaching Failed!');
          }
        }
      );
  }
}
