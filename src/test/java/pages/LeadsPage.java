package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.When;

public class LeadsPage extends base.ProjectSpecificMethods {

	
//	@When("Click on the Leads Tab")
//	public LeadsPage click_on_the_leads_tab() throws InterruptedException 
//	{
//		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a/span[text()='Leads']")));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/span[text()='Leads']")));
//		WebElement leadsTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/span[text()='Leads']")));
//		leadsTab.click();
//		return this;
//	}
	
	@When("Click on the New Lead Button")
	public CreateLead click_on_the_new_lead_button() throws InterruptedException {
		getDriver().findElement(By.xpath("//button[@name=\"New\"]")).click();
		Thread.sleep(2000);
		return new CreateLead();
	}
}
