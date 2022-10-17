package pageobjects;

import org.openqa.selenium.By;

public class CustomerProfileManagement 
{
//locators of My profile page
	public By account_button = By.id("currency");
	public By fname = By.name("firstname");
	public By lname = By.name("lastname");
	public By phone = By.name("phone");
	public By country = By.xpath("/html/body/section[1]/div/div[2]/div/div[1]/div/div/div[2]/form/div[1]/table/tbody/tr[6]/td[3]/div/div/span/span[1]/span");
	public By state = By.name("state");
	public By city = By.name("city");	
	public By fax = By.name("fax");
	public By postal = By.name("zip");	
	public By address = By.name("address1");
	public By success_msg = By.xpath("/html/body/section[1]/div/div[2]/div/div[1]/div/div/div[2]/form/div[1]/div");
	public By update_button = By.xpath("//button[@type='submit']");
	
	
}
