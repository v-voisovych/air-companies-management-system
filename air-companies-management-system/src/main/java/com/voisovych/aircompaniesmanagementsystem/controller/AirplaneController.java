package com.voisovych.aircompaniesmanagementsystem.controller;

import com.voisovych.aircompaniesmanagementsystem.exception.MyException;
import com.voisovych.aircompaniesmanagementsystem.model.Airplane;
import com.voisovych.aircompaniesmanagementsystem.service.airplane.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AirplaneController {

    private final AirplaneService airplaneService;

    @Autowired
    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @PutMapping("addNewAirplane")
    public ResponseEntity<String> addNewAirplane(@RequestBody Airplane airplane, @RequestParam String airCompanyName) throws MyException {
        airplaneService.addNewAirplane(airplane, airCompanyName);
        return ResponseEntity.ok("New airplane has added!!!");
    }

    @PostMapping("/changeAirCompany")
    public ResponseEntity<String> changeAirCompany(@RequestParam String factorySerialNumber, @RequestParam String airCompanyName) throws MyException {
        airplaneService.changeAirCompany(factorySerialNumber, airCompanyName);
        return ResponseEntity.ok("Air company has changed");
    }

    @GetMapping("/allAirplane")
    public ResponseEntity<Iterable<Airplane>> allAirplane () {
        return ResponseEntity.ok(airplaneService.allAirplane());
    }
}
