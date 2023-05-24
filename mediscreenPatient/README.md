# mediscreenPatient
### REST API to access Patients data from SQL database

## Technical :
1. Framework: Spring Boot v2.7.7
2. Java 11
3. Database: MySQL
4. HTML5 + CSS
5. Thymeleaf

## Set-Up :
1. Create SQL Database using ./doc/mediscreen database.sql
2. Create some test data using ./doc/mediscreen test data.sql

## REST API Endpoints :
1. GET - "/patients"
Get list of all patients data

2. GET - "/patient/{id}"
{id} (int) : id of a patient
Get data for one patient by id

3. GET - "/patient"
Url Parameter: {family} (string): family name of patients
Get list of patients data for one family name

4. POST - "/patient"
Request Body : {Patient}
Add a patient data into database

5. PUT - "/patient"
Request Body : {Patient}
Update a patient data into database

6. DELETE - "/patient/{id}"
{id} (int) : id of a patient
Delete data for one patient by id

##WEB pages
1. "/web/patient/list" : List Page
Show a list of all patients with their data
Allows to add a Patient (with a button redirecting to "Add Page")
For each Patient, allows to update data (with a button redirecting to "Update Page")
For each Patient, allows to delete data (with a button )

2. "/web/patient/add" : Add Page
Allow to write some data and create a new Patient

3. "/web/patient/update/{id}" : Update Page
{id} (int) : id of a patient
Show current data of the patient and allows to update it
