package com.boeing.flight.controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.Period;
import java.util.ArrayList;

import java.util.List;

import com.boeing.flight.model.Flight;
import com.boeing.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class FlightController {
	@Autowired
	private FlightService flightService;

	@GetMapping("/flights")
	public List<Flight> getAllFlights() {
		return flightService.getFlights();
	}
	@GetMapping("/flights/outbound")
	public List<Flight> getOutboundFlights() {
		return flightService.getOutbound();
	}
	@GetMapping("/flights/inbound")
	public List<Flight> getInboundFlights() {
		return flightService.getInbound();
	}

	@GetMapping("/flights/{flightNo}")
	public ResponseEntity<Flight> getFlightById(@PathVariable(value = "flightNo") String flightNo)
			throws Exception {
		Flight flight = flightService.fetchFlightDetails(flightNo);
		return ResponseEntity.ok().body(flight);
	}

	@PostMapping("/addFlight")
	public void addFlight(@Valid @RequestBody Flight flight) {
		flightService.save(flight);
	}
}
