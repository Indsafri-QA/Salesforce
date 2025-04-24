package Create_LeadsAPI;

import java.util.HashMap;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Create_Opportunity_API extends Generate_Token {
	
	String opportunityID;
	
	@Test
	public void runAPICRUD()
	{
		
		Create_Opportunity_API newOpp = new Create_Opportunity_API();
		String token = newOpp.generateToken();
		newOpp.createOpportunity(token);
		//newOpp.getOpportunity(token);
		//newOpp.updateOpportunity(token);
		//newOpp.deleteOpportunity(token);
	}	
	public void createOpportunity(String token)
	{
		RestAssured.baseURI = "https://testleaf72-dev-ed.develop.my.salesforce.com/services/data/v36.0/sobjects/";
		
		Map<String, String> map = new HashMap<>();
		map.put("Content-Type", "application/json");
		map.put("Authorization", "Bearer " + token);
		
		RequestSpecification req = RestAssured.given().headers(map).body("{\r\n"
				+ "    \"Name\": \"Call\",\r\n"
				+ "    \"StageName\": \"Qualification\",\r\n"
				+ "    \"CloseDate\": \"2023-12-07\"\r\n"
				+ "}\r\n"
				+ "");
		
		Response resp = req.when().post("Opportunity");
		String opportunityID = resp.jsonPath().getString("message");
		//System.out.println(opportunityID);
		System.out.println(resp.getStatusCode() + " with message: " + resp.getStatusLine());
		
		resp.prettyPrint();
	}
	public void getOpportunity(String oppToken)
	{
		RestAssured.baseURI = "https://testleaf72-dev-ed.develop.my.salesforce.com/services/data/v36.0/sobjects/";
		
		Map<String, String> map = new HashMap<>();
		map.put("Content-Type", "application/json");
		map.put("Authorization", "Bearer " + oppToken);
		
		Response resp = RestAssured.when().get("Opportunity/");
		resp.prettyPrint();
	}
	public void updateOpportunity(String oppToken)
	{
		RestAssured.baseURI = "https://testleaf72-dev-ed.develop.my.salesforce.com/services/data/v36.0/sobjects/";
		
		Map<String, String> map = new HashMap<>();
		map.put("Content-Type", "application/json");
		map.put("Authorization", "Bearer " + oppToken);
		
		RequestSpecification req = RestAssured.given().headers(map).body("{\r\n"
				+ "  \"Name\": \"New call Created Now 12\"");
		
		Response resp = req.when().put("Opportunity/" + opportunityID);
		resp.prettyPrint();
	}
	public void deleteOpportunity(String oppToken)
	{
		RestAssured.baseURI = "https://testleaf72-dev-ed.develop.my.salesforce.com/services/data/v36.0/sobjects/";
		
		Map<String, String> map = new HashMap<>();
		map.put("Content-Type", "application/json");
		map.put("Authorization", "Bearer " + oppToken);
		Response resp = RestAssured.when().delete("Opportunity/" + opportunityID);
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getStatusLine());
	}
	}
