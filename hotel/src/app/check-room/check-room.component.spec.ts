import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckRoomComponent } from './check-room.component';

describe('CheckRoomComponent', () => {
  let component: CheckRoomComponent;
  let fixture: ComponentFixture<CheckRoomComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckRoomComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckRoomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
