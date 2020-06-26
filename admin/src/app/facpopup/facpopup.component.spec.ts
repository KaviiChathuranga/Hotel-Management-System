import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FacpopupComponent } from './facpopup.component';

describe('FacpopupComponent', () => {
  let component: FacpopupComponent;
  let fixture: ComponentFixture<FacpopupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FacpopupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FacpopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
