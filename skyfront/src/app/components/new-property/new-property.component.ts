import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
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

  constructor(private propertyService: PropertyServiceService, private router:Router,
    private managerService:ManagerServiceService,
    private tenantService: TenantService,
    private formBuilder:FormBuilder) { 
      // this.propertyForm = this.formBuilder.group({  
      //   name: '',  
      //   quantities: this.formBuilder.array([]) ,  
      // });  
    }

  property: Property = new Property;
  manager!: Manager;
  managers: Manager[] = [];
  tenents: Tenant[] = [];

  private getTenants(){
    this.tenantService.getTenantList().subscribe(data =>{
      this.tenents = data;
    })
  };

  private getManagers(){
    this.managerService.getManagerList().subscribe(data =>{
      this.managers = data;
    });
  }
  
  ngOnInit(): void {
    this.getTenants();
    this.getManagers();
  }  
  
  onSubmit(){
    this.saveProperty();
    this.goToRoomDetails();
    console.log(this.property);
  }
  saveProperty(){
    this.propertyService.createProperty(this.property).subscribe(data => 
      {
        console.log(data);
      },
      error => console.log(error));
  }

  goToRoomDetails() {
    this.router.navigate(["/new-room"]);
  }
}
