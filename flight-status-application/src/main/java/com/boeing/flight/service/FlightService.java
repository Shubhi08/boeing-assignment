package com.boeing.flight.service;

import com.boeing.flight.model.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> getFlights();
    List<Flight> getInbound();
    List<Flight> getOutbound();
   Flight fetchFlightDetails(String flightNo);

    void save(Flight flight);


}
