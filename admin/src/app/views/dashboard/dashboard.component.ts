import { Component, OnInit } from '@angular/core';
// import {CustomerService} from "../../services/customer.service";
import {RoomsService} from '../../services/rooms.service';

// import {Orders} from "../../dtos/orders";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(
    private itemService: RoomsService) { }

  ngOnInit() {

  }
}
