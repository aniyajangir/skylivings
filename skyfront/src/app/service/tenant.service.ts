import { HttpClient } from '@angular/common/http';
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

  createTenant(tenant: Tenant):Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}`+"tenant", tenant);
  }
}
