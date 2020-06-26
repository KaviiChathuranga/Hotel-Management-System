import { Component, OnInit } from '@angular/core';
import {} from '@types/googlemaps';
import {ActivatedRoute} from '@angular/router';
@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.scss']
})
export class MapComponent implements OnInit {
  latitude = 7.8731;
  longitude = 80.7718;
  angular: any;
  routeID = this._route.snapshot.paramMap.get('id');
  constructor(private _route: ActivatedRoute) { }

  ngOnInit() {
    // this.routeID = this._route.snapshot.paramMap.get('id');
    //  alert(this.routeID);
  }
}
