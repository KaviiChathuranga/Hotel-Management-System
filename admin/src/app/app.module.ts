import { BrowserModule } from '../../node_modules/@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { DashboardComponent } from './views/dashboard/dashboard.component';
// import { ManageCustomersComponent } from './views/manage-customers/manage-customers.component';
// import {RouterModule, Routes} from "@angular/router";

// import {ManageCustomerComponentCandeactivateGuard} from "./guards/manage-customer-component-candeactivate.guard";
import { LoginComponent } from './views/login/login.component';
import { MainComponent } from './views/main/main.component';
// import {AppRoutingModule} from "./app-routing.module";
// import {AuthGuard} from "./guards/auth.guard";
// import {AuthService} from "./services/auth.service";
import { RoomsComponent } from './views/rooms/rooms.component';
// import {RoomsService} from "./services/item.service";
// import { PlaceOrderComponent } from './views/place-order/place-order.component';
// import {ManageRoomComponentCandeactivateGuardGuard} from "./guards/manage-item-component-candeactivate-guard.guard";
// import {PlaceOrder} from "./dtos/place-order";
// import {PlaceOrderServiceService} from "./services/place-order-service.service";
// import { ViewOrdersComponent } from './views/view-orders/view-orders.component';
import {RoomsService} from './services/rooms.service';
import {AppRoutingModule} from './app-routing.module';
import {FormsModule} from '../../node_modules/@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import {HttpClientModule} from '../../node_modules/@angular/common/http';
import {AuthService} from './services/auth.service';
import { FacilitiesComponent } from './facilities/facilities.component';
import { ReservationComponent } from './views/reservation/reservation.component';
import { CheckComponent } from './views/check/check.component';
import { FacpopupComponent } from './facpopup/facpopup.component';
import {Facilityservice} from './services/facility.service';
import {RoomsServiceFacility} from './services/roomFacility.service';
import {AuthGuard} from './guards/auth.guard';
import { UserComponent } from './user/user.component';
// import { MDBBootstrapModule } from 'angular-bootstrap-md';


@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    // ManageCustomersComponent,
    LoginComponent,
    MainComponent,
    RoomsComponent,
    FacilitiesComponent,
    ReservationComponent,
    CheckComponent,
    FacpopupComponent,
    UserComponent,
    // PlaceOrderComponent,
    // ViewOrdersComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    NgxPaginationModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [
    RoomsService,
    Facilityservice,
    AuthGuard,
    AuthService,
    RoomsServiceFacility
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
