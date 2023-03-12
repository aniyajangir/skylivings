import { Component, OnInit } from '@angular/core';
import { Tenant } from 'src/app/classes/tenant';
import { TenantService } from 'src/app/service/tenant.service';

@Component({
  selector: 'app-get-tenant',
  templateUrl: './get-tenant.component.html',
  styleUrls: ['./get-tenant.component.css']
})
export class GetTenantComponent implements OnInit {

  constructor(private tenantService: TenantService) { }
  tenant!:Tenant;
  tenantId!: number;
  showTenant: boolean = false;
  roommates!: Tenant[];

  ngOnInit(): void {
  }

  getTenantById(tenantId: number){
    this.tenantService.getTenantById(tenantId).subscribe(data=>{
      this.tenant = data;
      this.showTenant = true;
    });
    
    this.tenantService.getRoommates(tenantId).subscribe(data=>{
          this.roommates = data;
          console.log(data);
    });
  }

}
