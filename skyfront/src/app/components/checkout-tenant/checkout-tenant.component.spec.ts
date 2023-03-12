import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckoutTenantComponent } from './checkout-tenant.component';

describe('CheckoutTenantComponent', () => {
  let component: CheckoutTenantComponent;
  let fixture: ComponentFixture<CheckoutTenantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CheckoutTenantComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CheckoutTenantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
