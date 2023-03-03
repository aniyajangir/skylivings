import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Owner } from '../classes/owner';
import { Property } from '../classes/property';

@Injectable({
  providedIn: 'root'
})
export class PropertyServiceService {

  constructor(private httpClient: HttpClient) { }

  private baseUrl = "http://localhost:8080/"; 

  getPropertyList(): Observable<Property[]>{
    return this.httpClient.get<Property[]>(`${this.baseUrl}`+"property-list");
  }

  createProperty(property: Property):Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}`+"property", property);
  }
}
