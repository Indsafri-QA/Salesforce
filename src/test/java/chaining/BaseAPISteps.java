package chaining;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class BaseAPISteps {
	
	public static String sys_id;
	public Response response;
	
	@BeforeTest
	public void preSteps() throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("./src/test/resources/config.properties")));
		RestAssured.baseURI = "https://"+prop.getProperty("ServiceNow_Host")+"/"+prop.getProperty("ServiceNow_Table");
		RestAssured.authentication = RestAssured.basic(prop.getProperty("Username"), 
				prop.getProperty("Password"));
	}
	
	@AfterMethod
	public void postSteps() {
		response.then().log().all();
	}

}
