import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetTenantComponent } from './get-tenant.component';

describe('GetTenantComponent', () => {
  let component: GetTenantComponent;
  let fixture: ComponentFixture<GetTenantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetTenantComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetTenantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
