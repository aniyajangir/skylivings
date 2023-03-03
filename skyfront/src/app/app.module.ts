import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';  

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { NewTenantComponent } from './components/new-tenant/new-tenant.component';4
import { HttpClientModule } from '@angular/common/http';
import { NewPropertyComponent } from './components/new-property/new-property.component';
import { AddressComponent } from './components/address/address.component';
import { DynamicInputComponent } from './components/dynamic-input/dynamic-input.component';
import { HomeComponent } from './components/home/home.component';
import { NewRoomBookingComponent } from './new-room-booking/new-room-booking.component';
import { PropertyTenantsComponent } from './components/property-tenants/property-tenants.component';
import { NgFor } from '@angular/common';
import { NewManagerComponent } from './components/new-manager/new-manager.component';
import { NewRoomComponent } from './components/new-room/new-room.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NavbarComponent,
    NewTenantComponent,
    NewPropertyComponent,
    AddressComponent,
    DynamicInputComponent,
    HomeComponent,
    NewRoomBookingComponent,
    PropertyTenantsComponent,
    NewManagerComponent,
    NewRoomComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
