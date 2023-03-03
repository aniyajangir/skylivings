import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { NewManagerComponent } from './components/new-manager/new-manager.component';
import { NewPropertyComponent } from './components/new-property/new-property.component';
import { NewRoomComponent } from './components/new-room/new-room.component';
import { NewTenantComponent } from './components/new-tenant/new-tenant.component';
import { PropertyTenantsComponent } from './components/property-tenants/property-tenants.component';

const routes: Routes = [
  {path:'new-tenant', component:NewTenantComponent},
  {path:'new-property',component:NewPropertyComponent},
  {path:'new-manager', component:NewManagerComponent},
  {path:'property-tenants', component:PropertyTenantsComponent},
  {path:'new-room', component:NewRoomComponent},
  {path:"",component:HomeComponent, pathMatch: "full"},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
