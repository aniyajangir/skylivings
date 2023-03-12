import { Component, OnInit } from '@angular/core';
import { Tenant } from 'src/app/classes/tenant';
import { TenantService } from 'src/app/service/tenant.service';

@Component({
  selector: 'app-active-tenants',
  templateUrl: './active-tenants.component.html',
  styleUrls: ['./active-tenants.component.css']
})
export class ActiveTenantsComponent implements OnInit {

  activeTenants!:Tenant[];
  constructor(private tenantService: TenantService) { 
    this.tenantService.getActiveTenants().subscribe(data=>{
      this.activeTenants = data;
    }),
    console.error();
  }


  ngOnInit(): void {
  }

}
