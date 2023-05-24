# mediscreenPatient
### REST API to access Notes data from NoSQL database

## Technical :
1. Framework: Spring Boot v2.7.7
2. Java 11
3. Database NoSQL: MongoDB
4. HTML5 + CSS
5. Thymeleaf

## Set-Up :
1. Create NoSQL Database named 'mediscreen' on port 27017 (using MongoDB)
2. Create some test data using ./doc/initialNotesData.json

## REST API Endpoints :
1. GET - "/notes"
Get list of all notes data

2. GET - "/note/{id}"
{id} (String) : id of a note
Get data for one note by id

3. GET - "/note"
Url Parameter: {patId} (int): id of a patient
Get list of notes data for one patient by id

4. POST - "/note"
Request Body : {Note}
Add a note data into database

5. PUT - "/note"
Request Body : {Note}
Update a note data into database

6. DELETE - "/note/{id}"
{id} (int) : id of a note
Delete data for one note by id