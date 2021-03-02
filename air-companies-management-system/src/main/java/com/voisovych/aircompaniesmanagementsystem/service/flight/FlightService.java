package com.voisovych.aircompaniesmanagementsystem.service.flight;

import com.voisovych.aircompaniesmanagementsystem.exception.MyException;
import com.voisovych.aircompaniesmanagementsystem.model.Airplane;
import com.voisovych.aircompaniesmanagementsystem.model.Flight;
import com.voisovych.aircompaniesmanagementsystem.model.Status;
import com.voisovych.aircompaniesmanagementsystem.repository.flight.FlightRepository;
import com.voisovych.aircompaniesmanagementsystem.service.aircompany.AirCompanyService;
import com.voisovych.aircompaniesmanagementsystem.service.airplane.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final AirCompanyService airCompanyService;
    private final AirplaneService airplaneService;

    @Autowired
    public FlightService(FlightRepository flightRepository, AirCompanyService airCompanyService, AirplaneService airplaneService) {
        this.flightRepository = flightRepository;
        this.airCompanyService = airCompanyService;
        this.airplaneService = airplaneService;
    }

    public void addNewFlight(Flight flight, String factorySerialNumber) throws MyException {
        Airplane airplane = airplaneService.findAirplaneByFactorySerialNumber(factorySerialNumber);
        flight.setFlightStatus(Status.PENDING);
        flight.setAirCompanyId(airplane.getAirCompanyId());
        flight.setAirPlaneId(airplane.getId());
        flightRepository.save(flight);
    }

    public Flight findFlightByNumberOfFlight(String numberOfFlight) throws MyException {
        return Optional.ofNullable(flightRepository.findByNumberOfFlight(numberOfFlight))
                .orElseThrow(() -> new MyException("Flight with number: " + numberOfFlight + "doesn't exist"));
    }

    public void changeStatus(String numberOfFlight, String newStatus) throws MyException {
        Flight flight = findFlightByNumberOfFlight(numberOfFlight);
        switch (newStatus) {
            case "DELAYED": {
                flight.setFlightStatus(Status.DELAYED);
                flight.setDelayStartedAt(LocalDateTime.now());
                break;
            }
            case "COMPLETED": {
                flight.setFlightStatus(Status.COMPLETED);
                flight.setEndedAt(LocalDateTime.now());
                break;
            }
            case "ACTIVE": {
                flight.setFlightStatus(Status.ACTIVE);
                flight.setStartedAt(LocalDateTime.now());
                break;
            }
            default:
                throw new MyException("Wrong status has sent: " + newStatus);
        }
        flightRepository.save(flight);
    }

    public List<Flight> flightWithStatusActive() throws MyException {
        LocalDateTime resultTime = LocalDateTime.now().minusHours(24);
        if(flightRepository.findFlightsWithStatusActive(Status.ACTIVE,resultTime).isEmpty()){
            throw new MyException("No flights with status ACTIVE");
        }
        return flightRepository.findFlightsWithStatusActive(Status.ACTIVE, resultTime);
    }

    public List<Flight> findAirCompanyFlights(String airCompanyName, Status status) throws MyException {
        if(flightRepository.airCompanyFlights(airCompanyService.findAirCompanyByName(airCompanyName).getId(), status).isEmpty()){
            throw new MyException("Air company with name: " + airCompanyName + " doesn't have flights");
        }
        return flightRepository.airCompanyFlights(airCompanyService.findAirCompanyByName(airCompanyName).getId(), status);
    }

    public List<Flight> findFlightWithStatusCompleted() throws MyException {
        if (flightRepository.findFlightWithStatusCompleted(Status.COMPLETED).isEmpty()) {
            throw new MyException("No flights with status COMPLETED");
        }

        List<Flight> flightList = flightRepository.findFlightWithStatusCompleted(Status.COMPLETED);
        flightList = flightList.stream().filter(flight -> (ChronoUnit.MINUTES.between(flight.getStartedAt(), flight.getEndedAt()) >=
                        estimatedFlightTimeInMinutes(flight.getEstimatedFlightTime()))).collect(Collectors.toList());
        return flightList;
    }

    private long estimatedFlightTimeInMinutes(String time) {
        String[] array = time.split(":");
        return Long.parseLong(array[0]) * 60 + Long.parseLong(array[1]);
    }

    public Iterable<Flight> allFlights() {
        return flightRepository.findAll();
    }
}
