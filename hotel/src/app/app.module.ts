import { BrowserModule } from '@angular/platform-browser';
import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { AgmCoreModule} from '@agm/core';

import { AppComponent } from './app.component';

import { PopUpComponent } from './pop-up/pop-up.component';
import { FooterComponent } from './footer/footer.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SignupComponent } from './signup/signup.component';
import { ContactComponent } from './contact/contact.component';
import { CancelReservationComponent } from './cancel-reservation/cancel-reservation.component';
import { PricingComponent } from './pricing/pricing.component';
import { MiddleContainerComponent } from './middle-container/middle-container.component';
import {HomepageComponent} from './homepage/homepage.component';
import { CheckRoomComponent } from './check-room/check-room.component';
import { MapComponent } from './map/map.component';
import { ProfileComponent } from './profile/profile.component';
import {AppRoutingModule} from './app-routing.module';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {RoomsService} from './services/rooms.service';
import {ValuesService} from './services/values.service';
import { CartComponent } from './cart/cart.component';
import { PaymentComponent } from './payment/payment.component';
import {ReserveRoomService} from './services/reserve.service';
import {UserService} from './services/user.service';
import {PaymentService} from './services/payment.service';
import {CookieService} from 'ngx-cookie-service';
// import { MapComponent } from './map/map.component';


@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    PopUpComponent,
    FooterComponent,
    NavbarComponent,
    SignupComponent,
    ContactComponent,
    CancelReservationComponent,
    PricingComponent,
    MiddleContainerComponent,
    CheckRoomComponent,
    MapComponent,
    ProfileComponent,
    CartComponent,
    PaymentComponent,
    // MapComponent
  ],
  imports: [
    BrowserModule,
    MDBBootstrapModule.forRoot(),
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyAcx7N8DdQJJYTJaRHaiRAxONdykt5MEmA'
    }),
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  // exports: [
  //   HomepageComponent,
  //   PopUpComponent,
  //   FooterComponent,
  //   NavbarComponent,
  //   SignupComponent,
  //   ContactComponent,
  //   CancelReservationComponent,
  //   PricingComponent,
  //   MiddleContainerComponent
  // ],
  // entryComponents: [
  //   HomepageComponent,
  //   PopUpComponent,
  //   FooterComponent,
  //   NavbarComponent,
  //   SignupComponent,
  //   ContactComponent,
  //   CancelReservationComponent,
  //   PricingComponent,
  //   MiddleContainerComponent
  // ],
  schemas: [ NO_ERRORS_SCHEMA ],
  providers: [
    RoomsService,
    ReserveRoomService,
    UserService,
    PaymentService,
    CookieService,
    ValuesService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
