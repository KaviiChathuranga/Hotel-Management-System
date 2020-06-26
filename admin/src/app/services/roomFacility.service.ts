import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {RoomFacility} from '../dtos/roomFacility';


const MAIN_URL = 'http://localhost:8080';
const URL = '/api/v1/room_facilities';

@Injectable()
export class RoomsServiceFacility {
  constructor(private http: HttpClient) {}
  getAllIRoomsFacility(): Observable<Array<RoomFacility>> {
    return this.http.get<Array<RoomFacility>>(MAIN_URL + URL);
  }
  searchRoomFacility(code: String): Observable<RoomFacility> {
    return this.http.get<RoomFacility>(MAIN_URL + URL + '/' + code);
  }
  saveRoomsFacility(room: RoomFacility): Observable<boolean> {
    console.log(room.roomDto);
    return this.http.post<boolean>(MAIN_URL + URL, room);
  }
  getTotalRooms(): Observable<number> {
    return this.http.get<number>(MAIN_URL + URL + '/count');
  }
}
