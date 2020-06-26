///<reference path="../../../node_modules/@angular/core/src/metadata/directives.d.ts"/>
import {Component, OnInit, ViewChild} from '@angular/core';
import {UserService} from '../services/user.service';
import {User} from '../dtos/user';
import {NgForm} from '@angular/forms';
import {CookieService} from 'ngx-cookie-service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent implements OnInit {
// private loggedInStatus   = JSON.parse(localStorage.getItem('kavi') || 'false');
  cookieValue = 'UNKNOWN';
  private loggedInStatus;
  @ViewChild('myForm') myForm: NgForm;
  constructor(private userService: UserService, private cookieService: CookieService) { }
  user: User = new User();
  ngOnInit() {
  }
  signClick(user): void {
    // localStorage.setItem('kavii', 'true');
    // this.loggedInStatus = JSON.parse(localStorage.getItem('kavii') || 'false');
    // console.log(this.loggedInStatus);
    // this.cookieValue = this.cookieService.get('Tezst');
    // this.cookieService.set( 'Test', 'xxx' );
    this.userService.saveUser(this.user).subscribe(
      (value) => {
        if (value) {
          alert('Sign In Successfully');
          this.cookieService.set( 'Test', this.user.username );
        } else {
          alert('Sign In Failed');
        }
      }
    );
  }
}
// sbx
