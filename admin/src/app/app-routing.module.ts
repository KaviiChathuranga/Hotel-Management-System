import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DashboardComponent} from './views/dashboard/dashboard.component';
import {MainComponent} from './views/main/main.component';
import {RoomsComponent} from './views/rooms/rooms.component';
import {FacilitiesComponent} from './facilities/facilities.component';
import {ReservationComponent} from './views/reservation/reservation.component';
import {CheckComponent} from './views/check/check.component';
import {AuthGuard} from './guards/auth.guard';
import {LoginComponent} from './views/login/login.component';

const appRoutes: Routes = [
  {
    path: 'main',
    component: MainComponent,
    // canActivate: [AuthGuard],
    children: [
      {path: 'dashboard', component: DashboardComponent},
      {
        path: 'manage-rooms',
        component: RoomsComponent

      },
      {
        path: 'manage-facilities',
        component: FacilitiesComponent
      },
      {
        path: 'manage-reservation',
        component: ReservationComponent
      },
      {
        path: 'manage-check',
        component: CheckComponent
      },
      {
        path: '',
        pathMatch : 'full',
        redirectTo: '/main/dashboard'
      }
    ]

  },
  {path: 'login', component: LoginComponent},
   {path: '', pathMatch: 'full', redirectTo: '/main/dashboard'}
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
