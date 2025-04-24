package Create_LeadsAPI;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Generate_Token {

	public String generateToken()
	{
		String token;
		RestAssured.baseURI = "https://login.salesforce.com/services/oauth2/token";

		Map<String, String> map = new HashMap<>();
		map.put("grant_type", "password");
		map.put("client_id", "3MVG9VMBZCsTL9hmq6JV8Nb7kX8DKil1YJAHTrU9vOOdpnC8iMne4E0aGEW0TcCXRxnBbe4Tdknzss4dtxBHX");
		map.put("client_secret", "6C9E8B9557BC6605CE0782053172646ACD6EF17348C9049C69910163D7DF6AEB");
		map.put("username", "vidyar@testleaf.com");
		map.put("password", "Sales@123");
		
		RequestSpecification req = RestAssured.given().contentType(ContentType.URLENC).formParams(map);
		
		Response resp = req.when().post();
		resp.prettyPrint();
		token = resp.jsonPath().getString("access_token");
		System.out.println(token);
		return token;
	}
}
