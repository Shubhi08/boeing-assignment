package com.boeing.flight.service;

import com.boeing.flight.model.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> getFlights();
   Flight fetchFlightDetails(String flightNo);

    void save(Flight flight);


}
