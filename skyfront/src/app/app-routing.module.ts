import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActiveTenantsComponent } from './components/active-tenants/active-tenants.component';
import { CheckoutTenantComponent } from './components/checkout-tenant/checkout-tenant.component';
import { GetTenantComponent } from './components/get-tenant/get-tenant.component';
import { HomeComponent } from './components/home/home.component';
import { ManagerListComponent } from './components/manager-list/manager-list.component';
import { NewManagerComponent } from './components/new-manager/new-manager.component';
import { NewPropertyComponent } from './components/new-property/new-property.component';
import { NewRoomComponent } from './components/new-room/new-room.component';
import { NewTenantComponent } from './components/new-tenant/new-tenant.component';
import { PropertyTenantsComponent } from './components/property-tenants/property-tenants.component';

const routes: Routes = [
  {path:'new-tenant', component:NewTenantComponent},
  {path:'new-property',component:NewPropertyComponent},
  {path:'new-manager', component:NewManagerComponent},
  {path:'manager-list', component:ManagerListComponent},
  {path:'property-tenants', component:PropertyTenantsComponent},
  {path:'new-room', component:NewRoomComponent},
  {path:'checkout-tenant', component:CheckoutTenantComponent},
  {path:'active-tenants', component:ActiveTenantsComponent},
  {path:'get-tenant', component:GetTenantComponent},
  {path:"",component:HomeComponent, pathMatch: "full"},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
