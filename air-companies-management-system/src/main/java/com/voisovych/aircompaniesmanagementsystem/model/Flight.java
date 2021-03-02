package com.voisovych.aircompaniesmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "number_of_flight")
    private String numberOfFlight;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "flight_status")
    private Status flightStatus;
    @Column(name = "Air_company_id")
    private long airCompanyId;
    @Column(name = "airplane_id")
    private long airPlaneId;
    @Column(name = "departure_country")
    private String departureCountry;
    @Column(name = "destination_country")
    private String destinationCountry;
    @Column(name = "distance")
    private long distance;
    @Column(name = "estimated_flight_time")
    private String estimatedFlightTime;
    @Column(name = "started_at")
    private LocalDateTime startedAt;
    @Column(name = "ended_at")
    private LocalDateTime endedAt;
    @Column(name = "delay_started_at")
    private LocalDateTime delayStartedAt;
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Air_company_id", referencedColumnName = "ID")
    @Transient
    @JsonIgnore
    private AirCompany airCompany;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "airplane_id", referencedColumnName = "ID")
    @Transient
    @JsonIgnore
    private Airplane airplane;

    public Flight() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumberOfFlight() {
        return numberOfFlight;
    }

    public void setNumberOfFlight(String numberOfFlight) {
        this.numberOfFlight = numberOfFlight;
    }

    public Status getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(Status flightStatus) {
        this.flightStatus = flightStatus;
    }

    public long getAirCompanyId() {
        return airCompanyId;
    }

    public void setAirCompanyId(long airCompanyId) {
        this.airCompanyId = airCompanyId;
    }

    public long getAirPlaneId() {
        return airPlaneId;
    }

    public void setAirPlaneId(long airPlaneId) {
        this.airPlaneId = airPlaneId;
    }

    public String getDepartureCountry() {
        return departureCountry;
    }

    public void setDepartureCountry(String departureCountry) {
        this.departureCountry = departureCountry;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public String getEstimatedFlightTime() {
        return estimatedFlightTime;
    }

    public void setEstimatedFlightTime(String estimatedFlightTime) {
        this.estimatedFlightTime = estimatedFlightTime;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }

    public LocalDateTime getDelayStartedAt() {
        return delayStartedAt;
    }

    public void setDelayStartedAt(LocalDateTime delayStartedAt) {
        this.delayStartedAt = delayStartedAt;
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

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }
}
