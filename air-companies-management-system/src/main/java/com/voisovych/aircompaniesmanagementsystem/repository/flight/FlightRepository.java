package com.voisovych.aircompaniesmanagementsystem.repository.flight;

import com.voisovych.aircompaniesmanagementsystem.model.Flight;
import com.voisovych.aircompaniesmanagementsystem.model.Status;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {

    Flight findByNumberOfFlight(String numberOfFlight);

    @Query("SELECT f FROM Flight f WHERE f.flightStatus = :status AND f.startedAt <= :resultTime")
    List<Flight> findFlightsWithStatusActive (@Param("status") Status status, @Param("resultTime") LocalDateTime resultTime);

    @Query("select f FROM Flight f WHERE (f.airCompanyId = :airCompanyId) AND (f.flightStatus = :status)")
    List<Flight> airCompanyFlights(@Param("airCompanyId") long airCompanyId, @Param("status") Status status);

    @Query("SELECT f FROM Flight f WHERE f.flightStatus = :status")
    List<Flight> findFlightWithStatusCompleted(@Param("status") Status status);

    List<Flight> findAllByAirPlaneId(long id);
}
