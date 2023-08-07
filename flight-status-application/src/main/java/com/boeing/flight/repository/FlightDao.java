package com.boeing.flight.repository;

import com.boeing.flight.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FlightDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    public List<Flight> getAllFlights(){
        List<Flight> flights = new ArrayList<>();
        String fetchFlights = "Select * from flight";
        //MapSqlParameterSource
        flights =jdbcTemplate.query(fetchFlights,new FlightMapper());
        return flights;

    }

    public List<Flight> getFlightbyType(String flightType){
        String fetchFlight = "Select * from flight where flight_type = :flightType";
        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        sqlParameterSource.addValue("flightType", flightType);
        return jdbcTemplate.query(fetchFlight,sqlParameterSource,new FlightMapper());
    }

    public Flight getFlightbyId(String flightNo){
        String fetchFlight = "Select * from flight where flight_no = :flightNo";
        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        sqlParameterSource.addValue("flightNo", flightNo);
        return jdbcTemplate.queryForObject(fetchFlight,sqlParameterSource,new FlightMapper());

    }

    public void save(Flight flight) {
        String insertQuery = "insert into flight(id, actual_time, airline, estimate_time, source, destination, flight_no, flight_type, status) values (:id, :actualTime, :airline, :estimateTime, :source, :destination, :flightNo, :flightType, :status)";
        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        sqlParameterSource.addValue("id", flight.getId());
        sqlParameterSource.addValue("actualTime", flight.getActualTime());
        sqlParameterSource.addValue("airline", flight.getAirline());
        sqlParameterSource.addValue("estimateTime", flight.getEstimateTime());
        sqlParameterSource.addValue("source", flight.getSource());
        sqlParameterSource.addValue("destination", flight.getDestination());
        sqlParameterSource.addValue("flightNo", flight.getFlightNo());
        sqlParameterSource.addValue("flightType", flight.getFlightType());
        sqlParameterSource.addValue("status", flight.getStatus());

       jdbcTemplate.update(insertQuery,sqlParameterSource);
    }

    private class FlightMapper implements RowMapper<Flight> {

        @Override
        public Flight mapRow(ResultSet resultSet, int i) throws SQLException {
            Flight flight = new Flight();
            flight.setId(resultSet.getLong("ID"));
            flight.setAirline(resultSet.getString("AIRLINE"));
            flight.setFlightNo(resultSet.getString("FLIGHT_NO"));
            flight.setSource(resultSet.getString("SOURCE"));
            flight.setDestination(resultSet.getString("DESTINATION"));
            flight.setEstimateTime(resultSet.getTimestamp("ESTIMATE_TIME"));
            flight.setActualTime(resultSet.getTimestamp("ACTUAL_TIME"));
            if(flight.getEstimateTime().equals(flight.getActualTime())){
                flight.setStatus("On Time");
            }else{
                flight.setStatus("Delayed");
            }
            flight.setFlightType(resultSet.getString("FLIGHT_TYPE"));
            return flight;
        }
    }
}
