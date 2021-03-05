package com.voisovych.aircompaniesmanagementsystem.controller;

import com.voisovych.aircompaniesmanagementsystem.exception.MyException;
import com.voisovych.aircompaniesmanagementsystem.model.AirCompany;
import com.voisovych.aircompaniesmanagementsystem.service.aircompany.AirCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AirCompanyController {

    private final AirCompanyService airCompanyService;

    @Autowired
    public AirCompanyController(AirCompanyService airCompanyService) {
        this.airCompanyService = airCompanyService;
    }

    @PutMapping("/addNewAirCompany")
    public ResponseEntity<String> addNewAirCompany(@RequestBody AirCompany airCompany) {
        airCompanyService.addNewAirCompany(airCompany);
        return ResponseEntity.ok("Air company Created Successfully!!!");
    }

    @GetMapping("/findAllAirCompany")
    public List<AirCompany> allAirCompany() throws MyException {
        return airCompanyService.findAllAirCompany();
    }

    @GetMapping("findAirCompanyByName")
    public ResponseEntity<AirCompany> findAirCompanyByName(@RequestParam String name) throws MyException {
        return ResponseEntity.ok(airCompanyService.findAirCompanyByName(name));
    }

    @PostMapping("/updateAirCompany")
    public ResponseEntity<String> updateAirCompany(@RequestBody AirCompany airCompany) throws MyException {
        AirCompany editingAirCompany = airCompanyService.findAirCompanyByName(airCompany.getName());
        airCompany.setId(editingAirCompany.getId());
        airCompanyService.addNewAirCompany(airCompany);
        return ResponseEntity.ok("updated Successfully!!!");
    }

    @DeleteMapping("/deleteAirCompany")
    public ResponseEntity<String> deleteAirCompany(@RequestParam String name) throws MyException {
        airCompanyService.deleteAirCompany(name);
        return ResponseEntity.ok("deleted Successfully!!!");
    }
}
