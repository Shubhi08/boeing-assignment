import { Component, OnInit } from '@angular/core';
import { Flight } from '../flight';
import { Router } from '@angular/router';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})
export class AddFlightComponent implements OnInit {

  flight: Flight = new Flight();
  submitted = false;

  constructor(private flightService: FlightService,
    private router: Router) { }

  ngOnInit() {
  }

  save() {
    this.flightService.addFlight(this.flight)
      .subscribe(data => console.log(data), error => console.log(error));
    this.flight = new Flight();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/flights']);
  }
}
