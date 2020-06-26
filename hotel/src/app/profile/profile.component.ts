import { Component, OnInit } from '@angular/core';
import {CookieService} from 'ngx-cookie-service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
private cookieValue;
  constructor(private cookieService: CookieService, private router: Router) { }

  ngOnInit() {
  }
  logOut(): void {
    this.cookieValue = this.cookieService.get('Test');
    if (this.cookieValue === '') {
      alert('Warning! You Are Not SignIn Yet, SignIn Required');
      return;
    } else {
      console.log(this.cookieValue);
      this.cookieService.delete('Test');
      this.router.navigate(['/']);
    }
  }

}
