import {Component, ElementRef, NgModule, OnInit, ViewChild} from '@angular/core';
import {NgForm} from '@angular/forms';
import {setupRouter} from '@angular/router/src/router_module';
import {Router} from '@angular/router';
import * as $ from 'jquery';
import {RoomsService} from '../services/rooms.service';
import {ReserveRooms} from '../dtos/reserve';
import {ReserveRoomService} from '../services/reserve.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss']
})
export class HomepageComponent implements OnInit {
  middle: Array<number> = [1, 2];
  reserveRoom: ReserveRooms = new ReserveRooms();
  reserveRoomList: Array<ReserveRooms>;
  date = new Date();
  @ViewChild('frmDates') frmDates: NgForm;
  @ViewChild('frmrooms') frmrooms: NgForm;
  constructor(private elem: ElementRef, private router: Router,
              private roomserive: RoomsService,
              private reserveRoomService: ReserveRoomService) { }
  ngOnInit() {
    moveProgressBar();

    $(window).resize(function() {
      moveProgressBar();
    });
    function moveProgressBar() {
      // console.log("moveProgressBar");
      const getPercent = ($('.progress-wrap').data('progress-percent') / 100);
      const getProgressWrapWidth = $('.progress-wrap').width();
      const progressTotal = getPercent * getProgressWrapWidth;
      const animationLength = 2500;

      $('.progress-bar').stop().animate({
        left: progressTotal
      }, animationLength);
    }
    // $cookies.put('user', 'u1');
    // const username = $cookies.get('user');
  }
  searchReserveRoom(d1, d2): void {
        this.router.navigate(['/middle', {d1: d1, d2: d2}]);
  }
}
