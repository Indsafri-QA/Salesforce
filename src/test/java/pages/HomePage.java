package pages;

import org.openqa.selenium.By;

import io.cucumber.java.en.When;


public class HomePage extends base.ProjectSpecificMethods {
	
	@When("Click on the AppLauncher Button")
	public HomePage click_on_the_app_launcher_button() throws InterruptedException 
	{
		getDriver().findElement(By.xpath("//button[@title='App Launcher']")).click();
		Thread.sleep(2000);
		return this;
	}

	@When("Click on the View All Button")
	public HomePage click_on_the_view_all_button() 
	{
		getDriver().findElement(By.xpath("//button[@aria-label=\"View All Applications\"]")).click();
		return this;
	}

	@When("Search the Lead")
	public HomePage search_the_lead() throws InterruptedException 
	{
		getDriver().findElement(By.xpath("//input[@placeholder=\"Search apps or items...\"]")).sendKeys("Leads");
		Thread.sleep(2000);
		return this;
	}

	@When("Click On Leads Option")
	public LeadsPage click_on_leads_option() throws InterruptedException 
	{
		getDriver().findElement(By.xpath("//mark[text()='Leads']")).click();
		Thread.sleep(2000);
		return new LeadsPage();
	}
	public HomePage clickOnProfile() throws InterruptedException
	{
		getDriver().findElement(By.xpath("//div[@class='headerButtonBody']/following::span[@class='uiImage']")).click();
		Thread.sleep(2000);
		return this;
	}
	public LoginPage clickOnLogout()
	{
		getDriver().findElement(By.xpath("//span[@class='uiImage']/following::a[text()[normalize-space()='Log Out']]")).click();
		return new LoginPage();
	}	
}
