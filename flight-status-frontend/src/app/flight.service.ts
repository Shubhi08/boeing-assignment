import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Flight} from './flight';

@Injectable({
  providedIn: 'root'
})
export class FlightService {
  private baseUrl = 'http://localhost:8080/springboot/api/v1/flights';
  private newFlight = 'http://localhost:8080/springboot/api/v1/addFlight';

  constructor(private http: HttpClient) { }

  getFlightDetails(flightNo: any): Observable<any> {
    return this.http.get(`${this.baseUrl}/${flightNo}`);
  }

  addFlight(flight: Flight): Observable<any> {
    return this.http.post(`${this.newFlight}`, flight);
  }

    exportData(id: number, value: any): Observable<any> {
        return this.http.post(`${this.baseUrl}/${id}`, value);
    }

   getFlights(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
