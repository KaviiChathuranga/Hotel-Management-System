import {Rooms} from '../dtos/rooms';
import {Observable} from 'rxjs/Observable';
import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../dtos/user';
const MAIN_URL = 'http://localhost:8080';
const URL = '/api/v1/login';
@Injectable()
export class UserService {
  constructor(private http: HttpClient) {}
  saveUser(user: User): Observable<User> {
    return this.http.post<User>(MAIN_URL + URL + '/save/', user);
  }
  searchUser(email: String): Observable<User> {
    return this.http.get<User>(MAIN_URL + URL + '/email/' + email);
  }
}
