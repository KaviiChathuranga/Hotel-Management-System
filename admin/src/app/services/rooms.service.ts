import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Rooms} from '../dtos/rooms';
import {Observable} from 'rxjs';


const MAIN_URL = 'http://localhost:8080';
const URL = '/api/v1/rooms';

@Injectable()
export class RoomsService {
  constructor(private http: HttpClient) {}
  getAllIRooms(): Observable<Array<Rooms>> {
    return this.http.get<Array<Rooms>>(MAIN_URL + URL);
  }
  searchRoom(code: String): Observable<Rooms> {
    return this.http.get<Rooms>(MAIN_URL + URL + '/' + code);
  }
  getTotalRooms(): Observable<number> {
    return this.http.get<number>(MAIN_URL + URL + '/count');
  }
  saveRooms(room: Rooms): Observable<boolean> {
    return this.http.post<boolean>(MAIN_URL + URL, room);
  }
}

