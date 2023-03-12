import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tenant } from '../classes/tenant';

@Injectable({
  providedIn: 'root'
})
export class TenantService {

  constructor(private httpClient: HttpClient) { }

  private baseUrl = "http://localhost:8080/"; 

  getTenantList(): Observable<Tenant[]>{
    return this.httpClient.get<Tenant[]>(`${this.baseUrl}`+"tenant-list");
  }

  createTenant(tenant: any):Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}`+"tenant", tenant);
  }

  getActiveTenants(): Observable<Tenant[]>{
    return this.httpClient.get<Tenant[]>(`${this.baseUrl}`+"active-tenants");
  }

  getTenantById(tenantId: any):Observable<Tenant>{
    const url = "http://localhost:8080/get-tenant";
    let queryParams = new HttpParams().append("tenantId",tenantId);

   return this.httpClient.get<Tenant>(url,{params: queryParams});
  }

  getRoommates(tenantId: any):Observable<Tenant[]>{
    const url = "http://localhost:8080/get-roommates";
    let queryParams = new HttpParams().append("tenantId",tenantId);

   return this.httpClient.get<Tenant[]>(url,{params: queryParams});
  }
}
