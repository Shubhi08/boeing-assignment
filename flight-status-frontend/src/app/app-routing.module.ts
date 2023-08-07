import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FlightListComponent } from './flight-list/flight-list.component';
import { AddFlightComponent } from './add-flight/add-flight.component';
import { FlightDetailsComponent } from './flight-details/flight-details.component';


const routes: Routes = [

  { path: '', redirectTo: 'flights', pathMatch: 'full' },
  { path: 'flights', component: FlightListComponent },
  { path: 'flights/inbound', component: FlightListComponent },
  { path: 'flights/outbound', component: FlightListComponent },
  { path: 'add', component: AddFlightComponent },
  { path: 'details/:flightNo', component: FlightDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
