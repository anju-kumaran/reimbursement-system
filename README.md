# Expense Reimbursement System

The Expense Reimbursement System will manage the process of reimbursing employees for expenses incurred while on company time. 


## Technologies Used

- Java
- JUnit
- Spring Boot
- Spring Data
- Spring MVC
- Docker
- Postman
- Log4J
- Lombok
- Maven
- Hibernate
- GCP Cloud SQL
- MySQL


## Features
#### API 1
Request reimbursement API

-Employee can:
- Submit a reimbursement request
- View all of his reimbursements

-Finance Manager can:
- View all reimbursements
- Approve/Deny/Reassign reimbursements
- An email will be sent to the employee whenever there is an update

#### API 2
Email API
- Receives request from API-1 to send emails to specified employees.


## Getting Started

1. Fork this repository, then clone your fork of this repository using git clone.
2. Open the project as a maven project
3. Download dependenices.
4. Create a database named 'Reimbursements' in MySQL, either locally or remotely.
5. Run maven build to create jar file.
6. Use Dockerfile to generate docker image.
7. Use docker-compose.yml file for spinning up multiple containers.
8. For API-1, use http://localhost:7000/ to run locally.
9. API-2 uses server port 8080.


## Usage
All the employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.
