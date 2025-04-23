package stepsDefn;

import java.io.File;

import org.hamcrest.Matchers;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class IncidentManagementSteps {
	
	RequestSpecification inputRequest;
	Response response;
	String sys_id;
	
	@Given("Set the endpoint for incident management API")
	public void setEndPOint() {
		RestAssured.baseURI = "https://dev196137.service-now.com/api/now/table/incident";
	}
	
	@Given("Set the user credentials for authenticating the system")
	public void setAuth() {
		inputRequest = RestAssured
		.given()
		.auth()
		.basic("admin", "wL39b$PaJ$oN"); 
	}
	
	@Given("Set the queryparameter in the input request")
	public void setQueryParam() {
		inputRequest.queryParam("sysparm_fields", "sys_id, category, number, short_description");
	}
	
	@Given("Set the contentType for the input request")
	public void setContentType() {
		inputRequest.contentType(ContentType.JSON);
	}
	
	@When("User send POST request to Incident management API")
	public void sendRequest() {
		response = inputRequest.when().post();
		response.prettyPrint();
		sys_id = response.jsonPath().getString("result.sys_id");
	}
	
	@And("Set the file {string} in the requestbody")
	public void addFileInRequest(String fileName) {
		File inputFile = new File("./data/"+fileName+".json");
		inputRequest.body(inputFile);
	}
	
	@When("User send GET request to Incident management API")
	public void hitGetRequest() {
		response = inputRequest.when().get();
		response.prettyPrint();		
	}
	
	@When("User send PUT request to Incident management API")
	public void hitPutRequest() {
		response = inputRequest.when().put(sys_id);
		response.prettyPrint();	
	}
	
	@Then("Validate the status code is {int}")
	public void validateStatusCode(Integer statusCode) {
		response.then().assertThat().statusCode(Matchers.equalTo(statusCode));
	}

}
