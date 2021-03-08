code is here: https://github.com/v-voisovych/air-companies-management-system.git

You should download zip file, then unzip with program winrar or 7-zip,

Download and install docker, in folder with docker-compose file open terminal and enter the command : docker-compose up

PUT  localhost:8080/addNewAirCompany – endpoint for creating new air company, it accepts json : 
{
    "name":"Windrrose",
    "companyType":"transport",
    "foundedAt":"2012-07-10T09:00:38"
}

GET localhost:8080/findAllAirCompany – endpoint returns all air company;

GET localhost:8080/findAirCompanyByName -endpoint returns one air company, it accepts one param: name;

POST localhost:8080/updateAirCompany - accepts json: 
{
    "name":"Windrrose",
    "companyType":"transport",
    "foundedAt":"2012-07-10T09:00:38"
}, it updates air company, or returns bad request if company with that name doesn’t exist;

DELETE localhost:8080/deleteAirCompany – endpoint takes one param: name and deletes company, or returns bad request if company with that name doesn’t exist;

PUT localhost:8080/addNewAirplane – saves new Airplane, accept param: airCompanyName and json:
{
    "name": "An",
    "factorySerialNumber": "a555839",
    "numberOfFlights": 200,
    "flightDistance": 10000,
    "fuelCapacity": 500000,
    "type": "commercial"
}

POST localhost:8080/changeAirCompany – changes airplanes company, takes two params: factorySerialNumber(changed factory serial number of airplane) and CompanyName(changed company name)

PUT localhost:8080/addNewFlight – creates new flight, takes param: factorySerialNumber(factory serial number of airplane for flight) and json: 
{
    "numberOfFlight": "a82339",
    "departureCountry": "USA",
    "destinationCountry": "Ukraine",
    "distance": 112255,
    "estimatedFlightTime":"20:50"
}

POST localhost:8080/changeStatus – changes status of flight, takes two params: numberOfFlight(factory serial number of airplane) and newStatus(new status);

GET localhost:8080/flightWithStatusActive – returns flights with status ACTIVE and started more than 24 hours ago.

GET localhost:8080/findAirCompanyFlights – returns Air Company Flights by status, takes two params: airCompanyName and status;

GET localhost:8080/flightWithStatusCompleted – returns all Flights in COMPLETED status where difference between started and ended time is bigger than estimated flight time.

GET localhost:8080/allFlights - returns all flights.

GET localhost:8080/allAirplane – returns all airplans. 

