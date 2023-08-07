import { Flight } from '../flight';
import { Component, OnInit, Input } from '@angular/core';
import { FlightService } from '../flight.service';
import { FlightListComponent } from '../flight-list/flight-list.component';
import { Router, ActivatedRoute } from '@angular/router';
import { saveAs } from 'file-saver';


@Component({
  selector: 'app-flight-details',
  templateUrl: './flight-details.component.html',
  styleUrls: ['./flight-details.component.css']
})
export class FlightDetailsComponent implements OnInit {

  flightNo: any;
  flight: Flight;

  constructor(private route: ActivatedRoute, private router: Router,
              private flightService: FlightService) {
  }

  ngOnInit() {
    this.flight = new Flight();

    this.flightNo = this.route.snapshot.params['flightNo'];

    this.flightService.getFlightDetails(this.flightNo)
      .subscribe(data => {
        console.log(data);
        this.flight = data;
      }, error => console.log(error));
  }

  list() {
    this.router.navigate(['flights']);
  }

  download(data: Flight ) {
    const replacer = (key, value) => value === null ? '' : value;
    let csv = Object.values(data);
    // let csv = values.map(row => header.map(fieldName => JSON.stringify(row[fieldName], replacer)).join(','));
    csv.unshift(csv.join(','));
     let csvArray = csv.join(',');

    var blob = new Blob([csvArray], {type: 'text/csv'});
    saveAs(blob, 'myFile.csv');
  }
}
