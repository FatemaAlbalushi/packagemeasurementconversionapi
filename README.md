# Package Measurement Conversion API

This is a Java-based API for converting and processing measurements. It provides endpoints for converting measurement inputs and returning the converted measurements. The API is built using Spring Boot and can be containerized using Docker.

## Prerequisites

Before running the API, make sure you have the following installed:

- Java 17
- Maven
- Docker
- Docker Compose

## Installation


1. Open a terminal and navigate to the project directory.

2. Clone the repository to your local machine:
                 
       git clone https://github.com/FatemaAlbalushi/packagemeasurementconversionapi.git

3. Navigate to the project directory:
  
       cd packagemeasurementconversionapi
 
4. Build the project using Maven:
        
        mvn clean package
## Usage

### Running the API

Option 1: Docker Run

1. Open a terminal and navigate to the project directory.
2. Start the API container:
        
       docker run -p 8080:8080 -d measurement-conversion-api
        
3. The API will be accessible at http://localhost:8080/api/convert-measurements.

Option 2: Docker Compose

1. Make sure Docker Compose is installed on your machine. 
2. Open a terminal and navigate to the project directory.
3. Start the services defined in the Docker Compose file:
            
       docker-compose up 
    
4. The API will be accessible at http://localhost:8080/api/convert-measurements.

5. To stop the services, run:
       
       docker-compose down



## API Endpoints

The API provides the following endpoint for converting measurements:

    GET /api/convert-measurements

This endpoint accepts a measurement input as a query parameter and returns the converted measurements.

Example Request:
            
    GET /api/convert-measurements?input=abbcc

Example Response:

    [
        2,
        6
    ]
    
## Input Format
The measurement input should be a string consisting of alphabetic characters ('a' to 'z'),
underscores ('_'), numbers (0-9), and the letter 'z'. The input represents measurements
where each alphabetic character represents a unit and each 'z' represents a multiplier.
Underscores represent a zero value. The API converts the input into a list of integers representing the measurements.

## Error Handling
If the API receives an invalid or unsupported measurement input, it will return a 400 Bad Request response with an error message.
 
 

