# mediscreenDiabet
### Microservice for diabet assessment

## Technical :
1. Framework: Spring Boot v2.6.14
2. Java 11
3. Feign
4. HTML5 + CSS
5. Thymeleaf

## Set-Up :
1. Run microservice mediscreenPatient
2. Run microservice mediscreenNotes

## REST API Endpoints :

1. GET - "/assess/{id}"
{id} (int) : id of a patient
Get diabete risk status for one patient by id

2. GET - "/assess"
Url Parameter: {patientName} (string): family name of patients
Get diabete risk status for a list of patients by family name



##WEB pages
1. "/web/assess/{id}" : Diabete Assess By ID
Main information for a patient by ID, including diabet Assess


