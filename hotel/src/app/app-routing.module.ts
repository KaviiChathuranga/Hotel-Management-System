import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MiddleContainerComponent} from './middle-container/middle-container.component';
import {CartComponent} from './cart/cart.component';
import {CheckRoomComponent} from './check-room/check-room.component';
import {PaymentComponent} from './payment/payment.component';

const appRoutes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'middle',
        component: MiddleContainerComponent
      },
    ]
  },
   {path: 'next', component: CartComponent},
  {path: 'payment', component: PaymentComponent},
  {path: 'middle/check', component: CheckRoomComponent},
  // {path: 'next', redirectTo: '/next'}
];
@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {
}
