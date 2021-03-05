DROP TABLE IF EXISTS flight;
DROP TABLE IF EXISTS airplane;
DROP TABLE IF EXISTS air_company;

CREATE TABLE air_company (
    ID BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    company_type VARCHAR(50),
    founded_at DATETIME,
    PRIMARY KEY (ID)
);

INSERT INTO air_company(id, name, company_type, founded_at) values
    (1, 'WithAir', 'low-cost', '2020-04-10 06:00:38'),
    (2, 'Air', 'low-cost', '2017-03-10 15:00:38'),
    (3, 'YanAir', 'low-cost', '2018-02-10 06:00:38'),
    (4, 'TrustAir', 'low-cost', '2020-04-10 06:00:38'),
    (5, 'PolandAir', 'low-cost', '2017-04-10 06:00:38'),
    (6, 'USAAir', 'low-cost', '2001-02-08 06:00:38'),
    (7, 'ItalyAir', 'low-cost', '2020-04-10 06:00:38');

CREATE TABLE airplane (
    ID BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    factory_serial_number VARCHAR(50),
    air_company_id BIGINT,
    number_of_flights int,
    flight_distance int,
    fuel_capacity int,
    type VARCHAR (50),
    created_at DATETIME,
    PRIMARY KEY (ID),
    FOREIGN KEY (air_company_id) REFERENCES air_company(ID)
);

INSERT INTO airplane(id, name, factory_serial_number, air_company_id, number_of_flights, flight_distance, fuel_capacity, type, created_at) values
    (1, 'Boeing', 'a839', 1, 200, 10000, 50000, 'big plane',  '2020-04-10 06:00:38'),
    (2, 'Boeing747', 'a747', 2, 20, 15000, 450000, 'big plane',  '2019-04-10 06:00:38'),
    (3, 'AN Dream', 'a578', 3, 22, 10800, 550000, 'big plane', '2018-04-10 06:00:38'),
    (4, 'Boeing', 'a891', 4, 203, 10010, 650000, 'big plane', '2017-04-10 06:00:38'),
    (5, 'Boeing', 'a892', 5, 203, 10010, 650000, 'big plane', '2017-04-10 06:00:38'),
    (6, 'Boeing', 'a893', 6, 203, 10010, 650000, 'big plane', '2017-04-10 06:00:38'),
    (7, 'Boeing', 'a894', 7, 203, 10010, 650000, 'big plane', '2017-04-10 06:00:38');

CREATE TABLE flight (
    ID BIGINT NOT NULL AUTO_INCREMENT,
    number_of_flight VARCHAR(50),
    flight_status VARCHAR(50),
    Air_company_id BIGINT,
    airplane_id BIGINT,
    departure_country VARCHAR(255),
    destination_country VARCHAR(255),
    distance int,
    estimated_flight_time VARCHAR(50),
    started_at DATETIME,
    ended_at DATETIME,
    delay_started_at DATETIME,
    created_at DATETIME,
    PRIMARY KEY (ID),
    FOREIGN KEY (Air_company_id) REFERENCES air_company(ID),
    FOREIGN KEY (airplane_id) REFERENCES airplane(ID)
);

INSERT INTO flight(id, number_of_flight, flight_status, air_company_id, airplane_id, departure_country, destination_country, distance, estimated_flight_time, started_at, ended_at, delay_started_at, created_at) VALUES
(1, 'as456', 'PENDING', 1, 1, 'USA', 'UKRAINE', 458756, '20:50', null, null, null, current_date),
(2, 'as457', 'COMPLETED', 2, 2, 'Poland', 'UKRAINE', 458756, '1:50', '2021-02-02 06:00:38', '2021-03-02 06:00:38', null, '2021-02-02 06:00:38'),
(3, 'as458', 'ACTIVE', 3, 4, 'Italy', 'UKRAINE', 458756, '5:30', '2021-02-02 06:00:38', null, null, '2021-02-02 06:00:38'),
(4, 'as459', 'ACTIVE', 4, 4, 'France', 'UKRAINE', 458756, '6:10', '2021-02-02 06:00:38', null, null, '2021-02-02 06:00:38'),
(5, 'as4591', 'COMPLETED', 5, 5, 'Italy', 'UKRAINE', 458756, '2:10', '2021-02-02 06:00:38', '2021-02-02 07:00:38', null, '2021-02-02 06:00:38'),
(6, 'as4592', 'DELAYED', 6, 6, 'Poland', 'UKRAINE', 458756, '3:10', '2021-02-02 06:00:38', null, '2021-02-02 06:00:38', '2021-02-02 06:00:38'),
(7, 'as4593', 'DELAYED', 7, 7, 'France', 'UKRAINE', 458756, '2:10', '2021-02-02 06:00:38', null, '2021-02-02 06:00:38', '2021-02-02 06:00:38');