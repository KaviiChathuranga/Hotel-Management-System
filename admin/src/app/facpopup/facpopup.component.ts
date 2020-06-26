import {Component, OnInit, ViewChild} from '@angular/core';
import {Facilities} from '../dtos/facilities';
import {Facilityservice} from '../services/facility.service';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-facpopup',
  templateUrl: './facpopup.component.html',
  styleUrls: ['./facpopup.component.css']
})
export class FacpopupComponent implements OnInit {
  facility: Facilities = new Facilities();
  facilityList: Array<Facilities> = [];

  @ViewChild('frmfacility') frmfacility: NgForm;
  constructor(private facilityService: Facilityservice) { }

  ngOnInit() {
   this.getAllFacility();
  }

  saveFacility(): void {
    this.facilityService.saveFacility(this.facility).subscribe(
      value => {
        if (value != null) {
          alert('New Feature Added');
        } else {
          alert('New Feature Saving Failed');
        }
      }
    );
  }
  getAllFacility(): void {
    this.facilityService.getAllFacility().subscribe(
      value => {
        this.facilityList = value;
      }
    );
  }
  clear(): void {
  }
}
