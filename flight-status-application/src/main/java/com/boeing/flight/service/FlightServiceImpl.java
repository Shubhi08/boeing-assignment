package com.boeing.flight.service;

import com.boeing.flight.model.Flight;
import com.boeing.flight.repository.FlightDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlightServiceImpl implements FlightService{

    @Autowired
    FlightDao dao;
    @Override
    public List<Flight> getFlights() {
        return dao.getAllFlights();
    }

    @Override
    public List<Flight> getInbound() {
        return dao.getFlightbyType("Inbound");
    }

    @Override
    public List<Flight> getOutbound() {
        return dao.getFlightbyType("Outbound");
    }

    @Override
    public Flight fetchFlightDetails(String flightNo) {
        return dao.getFlightbyId(flightNo);
    }

    @Override
    public void save(Flight flight) {
        dao.save(flight);

    }
}
