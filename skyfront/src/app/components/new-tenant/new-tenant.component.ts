import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Property } from 'src/app/classes/property';
import { Room } from 'src/app/classes/room';
import { Tenant } from 'src/app/classes/tenant';
import { PropertyServiceService } from 'src/app/service/property-service.service';
import { TenantService } from 'src/app/service/tenant.service';

export interface FilterPayload{
  selectedDropdownValue? : any
}
@Component({
  selector: 'app-new-tenant',
  templateUrl: './new-tenant.component.html',
  styleUrls: ['./new-tenant.component.css']
})
export class NewTenantComponent implements OnInit {
  payload: FilterPayload = {};
  newTenantForm!: FormGroup;
  properties!: Property[];

  constructor(private tenantService: TenantService, 
          private propertyService: PropertyServiceService,
      private router:Router) { 
      this.propertyService.getPropertyList().subscribe(data=>{
        this.properties=data;
      });

      this.newTenantForm = new FormGroup({
        firstName: new FormControl(''),
        lastName: new FormControl(''),
        gender: new FormControl(''),
        email: new FormControl(''),
        contact: new FormControl(''),
        alternativeContact: new FormControl(''),
        flatNumber: new FormControl(''),
        streetName: new FormControl(''),
        city: new FormControl(''),
        state: new FormControl(''),
        country: new FormControl(''),
        zip: new FormControl(''),
        roomId: new FormControl(''),
        rent: new FormControl(''),
        checkInDate: new FormControl(''),
        propertyId: new FormControl(''),
        headRoomMate: new FormControl(''),
        deposit: new FormControl(''),
        aadharNumber: new FormControl(''),
        panNumber: new FormControl(''),
        passportNumber: new FormControl(''),
        passportExpiryDate: new FormControl(''),
        visaNumber: new FormControl(''),
        visaExpiryDate: new FormControl(''),
        visaType: new FormControl(''),
        nationality: new FormControl('')
      });


    }

  tenant: Tenant = new Tenant();
  propertyRooms!: Room[];
  propertyId!: number;
  roomRent!: number;
  deposit!: number;
  roomId!: number;
  country:string = 'India';

  

  ngOnInit(): void {
    this.newTenantForm.get('propertyId')?.valueChanges.subscribe((propertyId) =>{
      this.newTenantForm.get('roomId')?.reset();
      this.newTenantForm.get('roomId')?.disable();
      if(propertyId) {
          this.propertyService.getPropertyRooms(propertyId).subscribe(data=>{
          this.propertyRooms=data;
          this.newTenantForm.get('roomId')?.enable();
        }); 
      }
    });

    
    this.newTenantForm.get('roomId')?.valueChanges.subscribe((roomId) =>{
      this.newTenantForm.get('rent')?.reset();
      this.newTenantForm.get('rent')?.disable();
      if(roomId){
          this.propertyService.getPropertyRoomRent(this.newTenantForm.get('propertyId')?.value ,roomId).subscribe(data=>{
          this.roomRent=data;
          this.newTenantForm.get('rent')?.enable();
          this.newTenantForm.controls['rent'].setValue(data);
        });
      }
    });


    this.newTenantForm.get('roomId')?.valueChanges.subscribe((roomId) =>{
      this.newTenantForm.get('deposit')?.reset();
      this.newTenantForm.get('deposit')?.disable();
      if(roomId){
          this.propertyService.getPropertyRoomDeposit(roomId).subscribe(data=>{
          this.deposit=data;
          this.newTenantForm.get('deposit')?.enable();
          this.newTenantForm.controls['deposit'].setValue(data);
        });
      }
    });
 
  }

  onSubmit(){
    console.log(this.tenant);
    console.log(this.properties);
    console.log(this.propertyRooms);
    console.log(this.propertyId);
    this.saveTenant();
  }

  saveTenant(){
    this.tenantService.createTenant(this.newTenantForm.value).subscribe(data => 
      {
        this.goToActiveTenantList();
        console.log(data);
      },
      error => console.log(error));
  }

  getProperties(){
    this.propertyService.getPropertyList().subscribe(data =>{
      this.properties = data;
    },error=>alert("error"));
  }

  goToActiveTenantList(){
    this.router.navigate(["/active-tenants"]);
  }

  // onClickOfSelectedValue(event: any){
  //  this.payload.selectedDropdownValue = event.value;
  //  console.log(this.payload.selectedDropdownValue);
  //  this.fetchDetails(payload);
  // }
}
