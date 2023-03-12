import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActiveTenantsComponent } from './active-tenants.component';

describe('ActiveTenantsComponent', () => {
  let component: ActiveTenantsComponent;
  let fixture: ComponentFixture<ActiveTenantsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActiveTenantsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ActiveTenantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
