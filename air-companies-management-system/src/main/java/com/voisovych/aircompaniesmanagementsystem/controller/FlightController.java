package com.voisovych.aircompaniesmanagementsystem.controller;

import com.voisovych.aircompaniesmanagementsystem.exception.MyException;
import com.voisovych.aircompaniesmanagementsystem.model.Flight;
import com.voisovych.aircompaniesmanagementsystem.model.Status;
import com.voisovych.aircompaniesmanagementsystem.service.flight.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PutMapping("/addNewFlight")
    public ResponseEntity<String> addNewFlight(@RequestBody Flight flight, @RequestParam String factorySerialNumber) throws MyException {
        flightService.addNewFlight(flight, factorySerialNumber);
        return ResponseEntity.ok("Flight has created Successfully!!!!");
    }

    @PostMapping("/changeStatus")
    public ResponseEntity<String> changeStatus(@RequestParam String numberOfFlight, @RequestParam String newStatus) throws MyException {
        flightService.changeStatus(numberOfFlight, newStatus);
        return ResponseEntity.ok("Status has changed Successfully!!!!");
    }

    @GetMapping("/flightWithStatusActive")
    public ResponseEntity<List<Flight>> flightWithStatusActive() throws MyException {
        return ResponseEntity.ok(flightService.flightWithStatusActive());
    }

    @GetMapping("/findAirCompanyFlights")
    public ResponseEntity<List<Flight>> findAirCompanyFlights(@RequestParam String airCompanyName, @RequestParam Status status) throws MyException {
        return ResponseEntity.ok(flightService.findAirCompanyFlights(airCompanyName, status));
    }

    @GetMapping("/flightWithStatusCompleted")
    public ResponseEntity<List<Flight>> flightWithStatusCompleted() throws MyException {
        return ResponseEntity.ok(flightService.findFlightWithStatusCompleted());
    }

    @GetMapping("/allFlights")
    public ResponseEntity<Iterable<Flight>> allFlights() {
        return ResponseEntity.ok(flightService.allFlights());
    }
}
