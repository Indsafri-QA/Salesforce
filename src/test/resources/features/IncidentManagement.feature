Feature: Incident management in Service now API

Background:
Given Set the endpoint for incident management API
And Set the user credentials for authenticating the system
And Set the queryparameter in the input request

@Create @Smoke @Regression
Scenario: TC001 Create Incident with no body in the request
And Set the contentType for the input request
When User send POST request to Incident management API
Then Validate the status code is 201

@Get @Regression
Scenario: TC002 Get Incidents with queryparam
When User send GET request to Incident management API
Then Validate the status code is 200

@Create @Regression
Scenario Outline: TC003 Create Incident with request body as file in the request
And Set the contentType for the input request
And Set the file '<File_Name>' in the requestbody
When User send POST request to Incident management API
Then Validate the status code is 201

Examples:
|File_Name|
|CreateIncident_request2|
|CreateIncident_request|