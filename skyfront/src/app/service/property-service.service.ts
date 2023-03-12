import { HttpClient , HttpErrorResponse, HttpParams} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable } from 'rxjs';
import { throwError } from 'rxjs';
import { Owner } from '../classes/owner';
import { Property } from '../classes/property';
import { Room } from '../classes/room';
import { Tenant } from '../classes/tenant';

@Injectable({
  providedIn: 'root'
})
export class PropertyServiceService {

  constructor(private httpClient: HttpClient) { }

  private baseUrl = "http://localhost:8080/";

  getPropertyList(): Observable<Property[]>{
    return this.httpClient.get<Property[]>(`${this.baseUrl}`+"property-list");
  }

  createProperty(property: any):Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}`+"property", property);
  }

  createRoom(room: any):Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}`+"room", room);
  }

  getPropertyRooms(propertyId: any): Observable<Room[]>{
    const url = "http://localhost:8080/available-rooms";
    let queryParams = new HttpParams().append("propertyId",propertyId);
    
    return this.httpClient.get<Room[]>(url,{params: queryParams});
  }

  getPropertyRoomRent(propertyId: any, roomId: any):Observable<number>{
    const url = "http://localhost:8080/property-room-rent";
    let queryParams = new HttpParams().append("propertyId",propertyId)
                                      .append("roomId",roomId);
    return this.httpClient.get<number>(url,{params: queryParams});
  }

  getPropertyRoomDeposit(roomId: any):Observable<number>{
    const url = "http://localhost:8080/property-room-deposit";
    let queryParams = new HttpParams().append("roomId",roomId);
                                      
    return this.httpClient.get<number>(url,{params: queryParams});
  }

  getRoomTenants(propertyId: any, roomId: any):Observable<Tenant[]>{
    const url = "http://localhost:8080/property-room-tenants";
    let queryParams = new HttpParams().append("propertyId",propertyId)
                                      .append("roomId",roomId);
    return this.httpClient.get<Tenant[]>(url,{params: queryParams});
  }
}
