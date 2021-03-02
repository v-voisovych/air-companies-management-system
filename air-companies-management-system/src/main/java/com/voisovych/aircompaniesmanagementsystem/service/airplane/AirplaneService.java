package com.voisovych.aircompaniesmanagementsystem.service.airplane;

import com.voisovych.aircompaniesmanagementsystem.exception.MyException;
import com.voisovych.aircompaniesmanagementsystem.model.AirCompany;
import com.voisovych.aircompaniesmanagementsystem.model.Airplane;
import com.voisovych.aircompaniesmanagementsystem.repository.airplane.AirplaneRepository;
import com.voisovych.aircompaniesmanagementsystem.service.aircompany.AirCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirplaneService {

    private final AirplaneRepository airplaneRepository;
    private final AirCompanyService airCompanyService;

    @Autowired
    public AirplaneService(AirplaneRepository airplaneRepository, AirCompanyService airCompanyService) {
        this.airplaneRepository = airplaneRepository;
        this.airCompanyService = airCompanyService;
    }

    public void addNewAirplane(Airplane airplane, String airCompanyName) throws MyException {
        airplane.setAirCompanyId(airCompanyService.findAirCompanyByName(airCompanyName).getId());
        Optional<Airplane> airplaneOptional = Optional.ofNullable(airplaneRepository
                .findByFactorySerialNumber(airplane.getFactorySerialNumber()));
        if(airplaneOptional.isPresent()){
            throw new MyException("This airplane exists");
        }
        airplaneRepository.save(airplane);
    }

    public Airplane findAirplaneByFactorySerialNumber(String factorySerialNumber) throws MyException {
        return Optional.ofNullable(airplaneRepository
                .findByFactorySerialNumber(factorySerialNumber)).orElseThrow(() -> new MyException("This airplane doesn't exist"));
    }

    public void changeAirCompany(String factorySerialNumber, String airCompanyName) throws MyException {
        Airplane airplane = findAirplaneByFactorySerialNumber(factorySerialNumber);
        AirCompany airCompany = airCompanyService.findAirCompanyByName(airCompanyName);
        airplane.setAirCompanyId(airCompany.getId());
        airplaneRepository.save(airplane);
    }

    public Iterable<Airplane> allAirplane() {
        return airplaneRepository.findAll();
    }

}
