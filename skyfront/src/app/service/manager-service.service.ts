import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Manager } from '../classes/manager';
import { Tenant } from '../classes/tenant';

@Injectable({
  providedIn: 'root'
})
export class ManagerServiceService {

  private baseUrl = "http://localhost:8080/"; 

  constructor(private httpClient: HttpClient) { }
  getManagerList(): Observable<Manager[]>{
    return this.httpClient.get<Manager[]>(`${this.baseUrl}`+"manager-list");
  }

  createManager(manager: Manager):Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}`+"manager", manager);
  }

   checkoutTenant(tenant: any):Observable<Object>{                 
    return this.httpClient.post(`${this.baseUrl}`+"checkout-tenant", tenant);
  }

}
