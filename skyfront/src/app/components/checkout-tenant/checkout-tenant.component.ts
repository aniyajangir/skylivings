import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Property } from 'src/app/classes/property';
import { Room } from 'src/app/classes/room';
import { Tenant } from 'src/app/classes/tenant';
import { ManagerServiceService } from 'src/app/service/manager-service.service';
import { PropertyServiceService } from 'src/app/service/property-service.service';
import { TenantService } from 'src/app/service/tenant.service';

@Component({
  selector: 'app-checkout-tenant',
  templateUrl: './checkout-tenant.component.html',
  styleUrls: ['./checkout-tenant.component.css']
})
export class CheckoutTenantComponent implements OnInit {

  properties!: Property[];
  checkoutTenantForm!: FormGroup;
  propertyRooms!: Room[];
  roomTenants!: Tenant[];
  response!: string;
  tenant!: Tenant;

  constructor(private propertyService: PropertyServiceService, private managerService: ManagerServiceService,
    private router:Router) { 
    this.propertyService.getPropertyList().subscribe(data=>{
      this.properties=data;
    });
    this.checkoutTenantForm = new FormGroup({
      propertyId: new FormControl(''),
      checkOutDate: new FormControl(''),
      roomId: new FormControl(''),
      tenants: new FormControl(''),
      remarks: new FormControl(''),
      tenantId: new FormControl('')
    });
  }

  ngOnInit(): void {
    this.checkoutTenantForm.get('propertyId')?.valueChanges.subscribe((propertyId) =>{
      this.checkoutTenantForm.get('roomId')?.reset();
      this.checkoutTenantForm.get('roomId')?.disable();
      if(propertyId) {
          this.propertyService.getPropertyRooms(propertyId).subscribe(data=>{
          this.propertyRooms=data;
          this.checkoutTenantForm.get('roomId')?.enable();
        }); 
      }
    });

    
    this.checkoutTenantForm.get('roomId')?.valueChanges.subscribe((roomId) =>{
      this.checkoutTenantForm.get('tenants')?.reset();
      this.checkoutTenantForm.get('tenants')?.disable();
      if(roomId){
          this.propertyService.getRoomTenants(this.checkoutTenantForm.get('propertyId')?.value ,roomId).subscribe(data=>{
          this.roomTenants=data;
          this.checkoutTenantForm.get('tenants')?.enable();
        });
      }
    });
  }
  onSubmit(){
    this.managerService.checkoutTenant(this.checkoutTenantForm.value).subscribe(data=>{
     console.log(data);
    });
    this.goToHomePage();

  }
  goToHomePage(){
    this.router.navigate(["/"]);
  }
}
