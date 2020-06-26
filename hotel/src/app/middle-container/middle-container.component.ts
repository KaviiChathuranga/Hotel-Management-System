import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import * as $ from 'jquery';
import {CheckRoomComponent} from '../check-room/check-room.component';
import {RoomsService} from '../services/rooms.service';
import {Rooms} from '../dtos/rooms';
import {ValuesService} from '../services/values.service';
import {ReserveRoomService} from '../services/reserve.service';
import {ReserveRooms} from '../dtos/reserve';
import {ActivatedRoute, Router} from '@angular/router';
@Component({
  selector: 'app-middle-container',
  templateUrl: './middle-container.component.html',
  styleUrls: ['./middle-container.component.scss']
})
export class MiddleContainerComponent implements AfterViewInit, OnInit {
  @ViewChild(CheckRoomComponent) child;
  middle: Array<Rooms> = [];
  reserveRoomList: Array<ReserveRooms>;
  room = 'hi';
  d1;
  d2;
  constructor( private roomserive: RoomsService,
               private valuesService: ValuesService,
               private reserveRoomService: ReserveRoomService,
               private _route: ActivatedRoute,
               private router: Router) { }

  ngOnInit() {
    $(function() {
      $('.material-card > .mc-btn-action').click(function () {
        const card = $(this).parent('.material-card');
        const icon = $(this).children('i');
        icon.addClass('fa-spin-fast');

        if (card.hasClass('mc-active')) {
          card.removeClass('mc-active');

          window.setTimeout(function() {
            icon
              .removeClass('fa-arrow-left')
              .removeClass('fa-spin-fast')
              .addClass('fa-bars');

          }, 800);
        } else {
          card.addClass('mc-active');

          window.setTimeout(function() {
            icon
              .removeClass('fa-bars')
              .removeClass('fa-spin-fast')
              .addClass('fa-arrow-left');

          }, 800);
        }
      });
    });
    this.searchReserveRoom();
    this.loadRoom();
  }
  ngAfterViewInit() {
    this.child.checkRoom1(this.room);
    // this.formModal.show();
  }
  checkRoom(mid): void {
    this.room = mid;
    // this.valuesService.MiddleValues(mid);
  }
  loadRoom(): void {
    this.roomserive.getAllIRooms().subscribe(
      (value) => {
          this.middle = value;
      }
    );
  }
  searchReserveRoom(): void {
    this.d1 = this._route.snapshot.paramMap.get('d1');
     this.d2 = this._route.snapshot.paramMap.get('d2');
    this.reserveRoomService.searchReserveRoom(this.d1, this.d2).subscribe(
      (value) => {
        this.reserveRoomList = value;
      });
  }
  nextPage(id): void {
    this.router.navigate(['/next' , {id: id, d1: this.d1, d2: this.d2}]);
  }
}
