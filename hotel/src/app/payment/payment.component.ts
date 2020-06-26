import { Component, OnInit } from '@angular/core';
import {CookieService} from 'ngx-cookie-service';
import {PaymentService} from '../services/payment.service';
import {ReserveRoomService} from '../services/reserve.service';
import {RoomsService} from '../services/rooms.service';
import {ActivatedRoute} from '@angular/router';
import {Payment} from '../dtos/payment';
import {ReserveRooms} from '../dtos/reserve';
import {Rooms} from '../dtos/rooms';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.scss']
})
export class PaymentComponent implements OnInit {

  constructor( private cookieService: CookieService,
               private paymentService: PaymentService,
               private reserveService: ReserveRoomService,
               private roomService: RoomsService,
               private _route: ActivatedRoute) { }
  private cookieValue;
  routeID;
  price;
  d1;
  d2;
  payment;
  // reservation: ReserveRooms = new ReserveRooms();
  // room: Rooms = new Rooms();
  resID = 0;
  ngOnInit() {
    this.routeID = this._route.snapshot.paramMap.get('id');
    this.price = this._route.snapshot.paramMap.get('price');
    this.d1 = this._route.snapshot.paramMap.get('d1');
    this.d2 = this._route.snapshot.paramMap.get('d2');
    this.js();
  }
  js(): void {
    $('.cc-number').on('keyup change', function() {
      if ($(this).val().toString.length === 4) {
        $(this).next().focus();
      } else if ($(this).val().toString.length === 0) {
        // $(this).prev().focus();
      }
    });
    $('.button-cart').on('click', function(e) {
      e.stopPropagation();
      $('.cont-product').addClass('slide-right');
      $('.container').addClass('slide-cont-left');
      $(this).addClass('btn-hiding');
      setTimeout(function() {
        $('.cont-product').addClass('zindex');
      }, 300);
    });

    $('.product').on('click', function(e) {
      e.stopPropagation();
      $('.cont-options').removeClass('slideup');
      $('.product').removeClass('active');
      $(this).addClass('active');
      $(this).find('.cont-options').addClass('slideup');
    });

    $(window).on( 'click', function() {
      $('.product').removeClass('active');
      $('.cont-product').removeClass('zindex');
      $('.cont-product').removeClass('slide-right');
      $('.container').removeClass('slide-cont-left');
      $('.button-cart').removeClass('btn-hiding');
      $('.cont-options').removeClass('slideup');
    });

  }
  makePayment(): void {
  this.payment = new Payment();
    console.log('2222222');
    this.cookieValue = this.cookieService.get('Test');
    if (this.cookieValue === '') {
      alert('Warning! SignUp Required');
      return;
    }
    this.reserveService.getTotalReserveRooms().subscribe(
      (result) => {
          this.resID = result + 1;

      }
    );
    console.log('333333333333');
      this.roomService.searchRoom(this.routeID).subscribe(
        (value) => {
          if (value == null) {
            alert('Room Not Found');
            return;
          }
           // this.room = value;
          // console.log(this.room);
          this.payment.reservationDto.roomDto = value  ;
          this.payment.reservationDto.checkInDate = this.d1;
          this.payment.reservationDto.checkOutDate = this.d2;
          this.payment.reservationDto.status = 'da';
          this.payment.reservationDto.user = this.cookieValue;
          this.payment.reservationDto.id =  this.resID;
          // this.payment.reservationDto = this.reservation;
          this.payment.date = 'today';
          this.payment.fee = this.price;
          this.payment.status = 'none';
          // console.log(this.reservation);
          console.log(this.payment);
    }
  );
    console.log('4444444');
    // this.reserveService.reserveRoom(this.reservation).subscribe(
    //
    // );
      this.paymentService.savePayment(this.payment).subscribe(
        (value) => {
          if (value) {
            alert('Payment Will Be Successfully Added');
          } else {
            alert('Fix Some Errors! Payment Not Added');
          }
        }
      );

  }
  findLength(): void {

  }

}
