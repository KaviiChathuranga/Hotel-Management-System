import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, CanDeactivate} from '@angular/router';
import { Observable } from 'rxjs';
import {RoomsComponent} from '../views/rooms/rooms.component';
// import {RoomsComponent} from "../views/items/items.component";

@Injectable()
export class ManageRoomComponentCandeactivateGuardGuard implements CanDeactivate<RoomsComponent> {
  canDeactivate(component: RoomsComponent, currentRoute: ActivatedRouteSnapshot, currentState: RouterStateSnapshot,
                nextState?: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if (component.frmrooms.dirty) {
      return confirm('Are you sure you want to discard your changes?');
    }
    return true;
  }
}
