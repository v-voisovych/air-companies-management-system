package com.voisovych.aircompaniesmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "air_company")
public class AirCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "company_type")
    private String companyType;
    @Column(name = "founded_at")
    private LocalDateTime foundedAt;

    @OneToOne(mappedBy = "airCompany")
    @Transient
    @JsonIgnore
    private Airplane airplane;

    @OneToOne(mappedBy = "airCompany")
    @Transient
    @JsonIgnore
    private Flight flight;

    public AirCompany() {
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

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public LocalDateTime getFoundedAt() {
        return foundedAt;
    }

    public void setFoundedAt(LocalDateTime foundedAt) {
        this.foundedAt = foundedAt;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "AirCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", companyType='" + companyType + '\'' +
                ", foundedAt=" + foundedAt +
                ", airplane=" + airplane +
                ", flight=" + flight +
                '}';
    }
}
