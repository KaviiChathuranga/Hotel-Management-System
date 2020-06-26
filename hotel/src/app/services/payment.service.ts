import {Injectable} from '@angular/core';
import {Rooms} from '../dtos/rooms';
import {Observable} from 'rxjs/Observable';
import {HttpClient} from '@angular/common/http';
import {Payment} from '../dtos/payment';
import {ReserveRooms} from '../dtos/reserve';

const MAIN_URL = 'http://localhost:8080';
const URL = '/api/v1/payment';

@Injectable()
export class PaymentService {
  constructor(private http: HttpClient) {}
  getAllIPayment(): Observable<Array<Payment>> {
    return this.http.get<Array<Payment>>(MAIN_URL + URL);
  }
  searchPayment(code: String): Observable<Payment> {
    return this.http.get<Payment>(MAIN_URL + URL + '/' + code);
  }
  savePayment(payment: Payment): Observable<Payment> {
    console.log(payment);
    return this.http.post<Payment>(MAIN_URL + URL + '/', payment);
  }
}
