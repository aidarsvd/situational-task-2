# Data Dynamo

[//]: # (## YouTube video demonstration)

The project for processing the large dataset of weather data and calculate:
1. Heat Index
2. Heat Stress Index
3. Wind Chill Index


## General information
#### Language / Framework
- Java Oracle OpenJDK 17
- Spring Boot 3.2.2
- RabbitMQ

#### DBMS
- PostgreSQL


## Architecture



## Usage

#### Send request to Producer module
POST _/api/dataset/upload_

form-data: file

Response:

200

`OK!`


## Project Screenshots:

### Dataset CSV file example

### Dataset parsing

### Weather metadata calculations

### Weather data sending to the queue
