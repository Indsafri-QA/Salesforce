package pages;

import org.openqa.selenium.By;

import io.cucumber.java.en.When;

public class LoginPage extends base.ProjectSpecificMethods {

	@When("Enter the Username as {string}")
	public LoginPage enter_the_username_as(String string) 
	{
		getDriver().findElement(By.id("username")).sendKeys(string);
		return this;
	}

	@When("Enter the Password as {string}")
	public LoginPage enter_the_password_as(String string) 
	{
		getDriver().findElement(By.id("password")).sendKeys(string);
		return this;
	}

	@When("Click on the Login button")
	public HomePage click_on_the_login_button() throws InterruptedException {
		getDriver().findElement(By.id("Login")).click();
		Thread.sleep(3000);
		return new HomePage();
	}
}
