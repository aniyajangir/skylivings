import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Property } from 'src/app/classes/property';
import { Tenant } from 'src/app/classes/tenant';
import { PropertyServiceService } from 'src/app/service/property-service.service';
import { TenantService } from 'src/app/service/tenant.service';

@Component({
  selector: 'app-new-tenant',
  templateUrl: './new-tenant.component.html',
  styleUrls: ['./new-tenant.component.css']
})
export class NewTenantComponent implements OnInit {

  constructor(private tenantService: TenantService, 
          private propertyService: PropertyServiceService,
    private router:Router) { }

  tenant: Tenant = new Tenant();
  properties!: Property[];
  
  ngOnInit(): void {
    this.getProperties();
  }

  onSubmit(){
    console.log(this.tenant);
    this.saveTenant();
  }

  saveTenant(){
    this.tenantService.createTenant(this.tenant).subscribe(data => 
      {
        this.goToTenantList();
        console.log(data);
      },
      error => console.log(error));
  }

  getProperties(){
    this.propertyService.getPropertyList().subscribe(data =>{
      this.properties = data;
    });
  }

  goToTenantList(){
    this.router.navigate(["/property-tenants"]);
  }


}
