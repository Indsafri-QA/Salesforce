package runner;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class TC001_Create_SalesLeadUI extends ProjectSpecificMethods {
	
	@Test
	public void createLead() throws InterruptedException
	{
		LoginPage login = new LoginPage();
		login.enter_the_username_as("vidyar@testleaf.com")
		.enter_the_password_as("Sales@123")
		.click_on_the_login_button()
		.click_on_the_app_launcher_button()
		.click_on_the_view_all_button()
		.search_the_lead()
		.click_on_leads_option()
		.click_on_the_new_lead_button()
		.choose_salutation_title()
		.enter_the_first_name_as("Anele Steyn")
		.enter_the_last_name_as("Nqari")
		.enter_the_company_name_as("Indsafri")
		.click_on_the_save_button();
	}

}
