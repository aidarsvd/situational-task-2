# Data Dynamo

## YouTube video demonstration

https://youtu.be/5Gk4hfStHnI

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
![Untitled Diagram drawio (1)](https://github.com/user-attachments/assets/bc02172e-58a8-42cc-a7ff-7b36d1fb20c7)

## Usage

#### Send request to Producer module
POST _/api/dataset/upload_

form-data: file

Response:

200

`OK!`


## Project Screenshots:

### Dataset CSV file example
<img width="1027" alt="Screenshot 2024-08-02 at 01 56 17" src="https://github.com/user-attachments/assets/460bdb40-cea1-426e-9695-53b634a0f2c6">

### Dataset parsing
![csv_proc](https://github.com/user-attachments/assets/612c4406-0b79-478f-a4fb-5f1107803616)

### Weather metadata calculations
![calculate](https://github.com/user-attachments/assets/e68a74bd-2c1e-48d1-9ad4-a669fc778344)

### Weather data sending to the queue
![sending_data](https://github.com/user-attachments/assets/20361486-cd25-4299-8259-1f2016eaf5c1)
