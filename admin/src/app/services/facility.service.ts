import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Facilities} from '../dtos/facilities';

const MAIN_URL = 'http://localhost:8080';
const URL = '/api/v1/facilities';
@Injectable()
export class Facilityservice {
  constructor(private http: HttpClient) {}

  getAllFacility(): Observable<Array<Facilities>> {
    return this.http.get<Array<Facilities>>(MAIN_URL + URL);
  }
  searchFacility(code: String): Observable<Facilities> {
    return this.http.get<Facilities>(MAIN_URL + URL + '/' + code);
  }
  getTotalFacility(): Observable<number> {
    return this.http.get<number>(MAIN_URL + URL + '/count');
  }
  saveFacility(facility: Facilities): Observable<boolean> {
    return this.http.post<boolean>(MAIN_URL + URL, facility);
  }
}
