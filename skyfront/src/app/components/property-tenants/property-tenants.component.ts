import { Component, OnInit } from '@angular/core';
import { Tenant } from 'src/app/classes/tenant';
import { TenantService } from 'src/app/service/tenant.service';

@Component({
  selector: 'app-property-tenants',
  templateUrl: './property-tenants.component.html',
  styleUrls: ['./property-tenants.component.css']
})
export class PropertyTenantsComponent implements OnInit {

  constructor(private tenantService: TenantService) { }

  tenants: Tenant[] = [];

  ngOnInit(): void {
    this.getTenant();
  }

  private getTenant(){
    this.tenantService.getTenantList().subscribe(data =>{
      this.tenants = data;
    });
  }
}
