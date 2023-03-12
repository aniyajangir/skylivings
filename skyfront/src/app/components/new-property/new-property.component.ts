import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { Manager } from 'src/app/classes/manager';
import { Property } from 'src/app/classes/property';
import { Tenant } from 'src/app/classes/tenant';
import { ManagerServiceService } from 'src/app/service/manager-service.service';
import { PropertyServiceService } from 'src/app/service/property-service.service';
import { TenantService } from 'src/app/service/tenant.service';

@Component({
  selector: 'app-new-property',
  templateUrl: './new-property.component.html',
  styleUrls: ['./new-property.component.css']
})
export class NewPropertyComponent implements OnInit {

  constructor(private propertyService: PropertyServiceService, private router: Router,
    private managerService: ManagerServiceService,
    private tenantService: TenantService,
    private formBuilder: FormBuilder) { }

  property: Property = new Property;
  manager!: Manager;
  managers: Manager[] = [];
  tenents: Tenant[] = [];


  propertyForm = new FormGroup({
    propertyCode: new FormControl(''),
    propertyType: new FormControl(''),
    propertyName: new FormControl(''),
    propertyStatus: new FormControl(''),
    buildingName: new FormControl(''),
    streetName: new FormControl(''),
    city: new FormControl(''),
    state: new FormControl(''),
    country: new FormControl(''),
    zip: new FormControl(''),
    onBoardingDate: new FormControl(''),
    ownerId: new FormControl(''),
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    contact: new FormControl(''),
    alternativeContact: new FormControl(''),
    email: new FormControl(''),
    gender: new FormControl(''),
    rooms: new FormArray([]),
    managerId: new FormControl('')
  });

  ngOnInit(): void {
    this.getTenants();
    this.getManagers();
  }

  private getTenants() {
    this.tenantService.getTenantList().subscribe(data => {
      this.tenents = data;
    })
  };

  private getManagers() {
    this.managerService.getManagerList().subscribe(data => {
      this.managers = data;
    });
  }

  newRoom(): FormGroup {
    return new FormGroup({
      roomType: new FormControl(''),
      roomNumber: new FormControl(''),
      roomSize: new FormControl(''),
      capacity: new FormControl(''),
      bedrooms: new FormControl(''),
      bathrooms: new FormControl(''),
      rent: new FormControl(''),
      deposit: new FormControl(''),
      description: new FormControl(''),
    });
  }

  get rooms(){
    return (<FormArray>this.propertyForm.get('rooms')).controls;
  }

  addRoom() {
   (<FormArray>this.propertyForm.get('rooms')).push(this.newRoom());
  }

  // removeRoom(i: number) {
  //   this.rooms().removeAt(i);
  // }

  onSubmit() {
    console.log(this.propertyForm.value)
    this.saveProperty();
  }
  saveProperty() {
    this.propertyService.createProperty(this.propertyForm.value).subscribe(data => {
      console.log(data);
    },
      error => console.log(error));
  }
}

