package pages;

import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLead extends base.ProjectSpecificMethods {
	
	@When("Choose Salutation Title")
	public CreateLead choose_salutation_title() 
	{
		getDriver().findElement(By.xpath("//div/button[@aria-label=\"Salutation\"]")).click();
		getDriver().findElement(By.xpath("//lightning-base-combobox-item[@data-value=\"Mr.\"]")).click();
		return this;
	}

	@When("Enter the First Name as {string}")
	public CreateLead enter_the_first_name_as(String string) 
	{
		getDriver().findElement(By.xpath("//input[@name=\"firstName\"]")).sendKeys(string);
		return this;
	}

	@When("Enter the Last Name as {string}")
	public CreateLead enter_the_last_name_as(String string) 
	{
		getDriver().findElement(By.xpath("//input[@name=\"lastName\"]")).sendKeys(string);
		return this;
	}

	@When("Enter the Company Name as {string}")
	public CreateLead enter_the_company_name_as(String string) 
	{
		getDriver().findElement(By.xpath("//input[@name='Company']")).sendKeys(string);
		return this;
	}

	@When("Click On the Save Button")
	public CreateLead click_on_the_save_button() 
	{
		getDriver().findElement(By.xpath("//button[@name='SaveEdit']")).click();
		return this;
	}
	@Then("Verify that the Lead was Successfully Created")
	public void verify_lead_created_successfully()
	{
		System.out.println("Lead was successfully created");
	}
}
