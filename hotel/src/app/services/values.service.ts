import {HttpClient} from '@angular/common/http';

export class ValuesService {
//  constructor(private http: HttpClient) {}
  $mid;
  MiddleValues(mid): void {
    this.$mid = mid;
  }
  getValue(): string {
    return this.$mid;
  }
}
