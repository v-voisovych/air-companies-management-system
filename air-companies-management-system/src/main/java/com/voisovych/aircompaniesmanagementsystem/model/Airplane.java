package com.voisovych.aircompaniesmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "airplane")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "factory_serial_number")
    private String factorySerialNumber;
    @Column(name = "air_company_id")
    private long airCompanyId;
    @Column(name = "number_of_flights")
    private int numberOfFlights;
    @Column(name = "flight_distance")
    private int flightDistance;
    @Column(name = "fuel_capacity")
    private int fuelCapacity;
    @Column(name = "type")
    private String type;
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "air_company_id", referencedColumnName = "ID")
    @Transient
    @JsonIgnore
    private AirCompany airCompany;

    @OneToOne(mappedBy = "airplane")
    @Transient
    @JsonIgnore
    private Flight flight;

    public Airplane() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFactorySerialNumber() {
        return factorySerialNumber;
    }

    public void setFactorySerialNumber(String factorySerialNumber) {
        this.factorySerialNumber = factorySerialNumber;
    }

    public long getAirCompanyId() {
        return airCompanyId;
    }

    public void setAirCompanyId(long airCompanyId) {
        this.airCompanyId = airCompanyId;
    }

    public int getNumberOfFlights() {
        return numberOfFlights;
    }

    public void setNumberOfFlights(int numberOfFlights) {
        this.numberOfFlights = numberOfFlights;
    }

    public int getFlightDistance() {
        return flightDistance;
    }

    public void setFlightDistance(int flightDistance) {
        this.flightDistance = flightDistance;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public AirCompany getAirCompany() {
        return airCompany;
    }

    public void setAirCompany(AirCompany airCompany) {
        this.airCompany = airCompany;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", factorySerialNumber='" + factorySerialNumber + '\'' +
                ", airCompanyId=" + airCompanyId +
                ", numberOfFlights=" + numberOfFlights +
                ", flightDistance=" + flightDistance +
                ", fuelCapacity=" + fuelCapacity +
                ", type='" + type + '\'' +
                ", createdAt=" + createdAt +
                ", airCompany=" + airCompany +
                ", flight=" + flight +
                '}';
    }
}
