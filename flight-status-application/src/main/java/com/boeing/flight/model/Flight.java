package com.boeing.flight.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Flight {

	@Id
	private Long id;
	@Column
	private String airline;
	@Column
	private String flightNo;
	@Column
	private String status;
	@Column
	private Timestamp estimateTime;
	@Column
	private Timestamp actualTime;
	@Column
	private String flightType;
	@Column
	private String source;
	@Column
	private String destination;

	public Flight(){

	}
	public Flight(Long id, String airline, String flightNo, String status, Timestamp estimateTime, Timestamp actualTime, String flightType, String source, String destination) {
		this.id = id;
		this.airline = airline;
		this.flightNo = flightNo;
		this.status = status;
		this.estimateTime = estimateTime;
		this.actualTime = actualTime;
		this.flightType = flightType;
		this.source = source;
		this.destination = destination;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getEstimateTime() {
		return estimateTime;
	}

	public void setEstimateTime(Timestamp estimateTime) {
		this.estimateTime = estimateTime;
	}

	public Timestamp getActualTime() {
		return actualTime;
	}

	public void setActualTime(Timestamp actualTime) {
		this.actualTime = actualTime;
	}

	public String getFlightType() {
		return flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
