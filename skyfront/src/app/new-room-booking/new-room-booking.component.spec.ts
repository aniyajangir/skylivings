import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewRoomBookingComponent } from './new-room-booking.component';

describe('NewRoomBookingComponent', () => {
  let component: NewRoomBookingComponent;
  let fixture: ComponentFixture<NewRoomBookingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewRoomBookingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewRoomBookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
