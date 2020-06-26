import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Rooms} from '../dtos/rooms';
import {Observable} from 'rxjs/Observable';
import {RoomFacilities} from '../dtos/roomFacilities';
import {ReserveRooms} from '../dtos/reserve';
import {User} from '../dtos/user';
import {Payment} from '../dtos/payment';

const MAIN_URL = 'http://localhost:8080';
const URL = '/api/v1/reservation';

@Injectable()
export class ReserveRoomService {
  constructor(private http: HttpClient) {}
  getAllReserveRoom(): Observable<Array<ReserveRooms>> {
    return this.http.get<Array<ReserveRooms>>(MAIN_URL + URL);
  }
  searchReserveRoom(d1: String, d2: String): Observable<Array<ReserveRooms>> {
    return this.http.get<Array<ReserveRooms>>(MAIN_URL + URL + '/' + d1 + '/' + d2);
  }
  reserveRoom(room: ReserveRooms): Observable<ReserveRooms> {
    return this.http.post<ReserveRooms>(MAIN_URL + URL + '/', room);
  }

  getTotalReserveRooms(): Observable<number> {
    return this.http.get<number>(MAIN_URL + URL + '/count');
  }
}

