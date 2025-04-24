package base;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class ProjectSpecificMethods extends AbstractTestNGCucumberTests {

private static final ThreadLocal<RemoteWebDriver> cDriver = new ThreadLocal<RemoteWebDriver>();
	
	public void setDriver() 
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		cDriver.set(new ChromeDriver(option));
	}

	@BeforeMethod
	public void preCondition()
	{
		setDriver();
		getDriver().manage().window().maximize();
		getDriver().get("https://login.salesforce.com/");
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@AfterMethod
	public void postCondition()
	{
		getDriver().quit();
	}
	public static RemoteWebDriver getDriver() 
	{
		return cDriver.get();
	}
}
