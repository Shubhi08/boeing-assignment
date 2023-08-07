import { Component, OnInit } from '@angular/core';

import { Observable } from "rxjs";
import { FlightService } from "../flight.service";
import { Flight } from "../flight";
import { Router } from '@angular/router';
import {async} from "rxjs/internal/scheduler/async";

@Component({
  selector: 'app-flight-list',
  templateUrl: './flight-list.component.html',
  styleUrls: ['./flight-list.component.css']
})
export class FlightListComponent implements OnInit {

  flights: Observable<Flight[]>;
  searchText: string;

  constructor(private flightService: FlightService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.flights = this.flightService.getFlights();
  }

  flightDetails(flightNo: any){
    this.router.navigate(['details', flightNo]);
  }

  protected readonly async = async;
}
