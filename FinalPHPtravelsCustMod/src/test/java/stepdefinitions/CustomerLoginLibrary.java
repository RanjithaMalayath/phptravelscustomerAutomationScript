package stepdefinitions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.CustomerLoginPOM;
import pageobjects.CustomerProfileManagement;
import pageobjects.HotelBookingPOM;
import utils.BasePage;

public class CustomerLoginLibrary extends BasePage
{
	
	
	CustomerLoginPOM cl = new CustomerLoginPOM();
	HotelBookingPOM hb = new HotelBookingPOM();
	CustomerProfileManagement profile = new CustomerProfileManagement();
	String cname, pname;
	String resno1,resno2;
	


	
	@Given("^I login to customer portal with Emailid as \"([^\"]*)\"$")

	public void custLogin(String uname) 
	{
	    driver.findElement(cl.account_button).click();	 
		driver.findElement(cl.customerlogin_link).click();
	    driver.findElement(cl.email_element).sendKeys(uname);
	}
	
	@Given("^I login to Admin portal with Emailid as \"([^\"]*)\"$")
	public void adminLogin(String eml) throws InterruptedException
	{
	  driver.navigate().to("https://www.phptravels.net/admin");
	  Thread.sleep(2000);
	  Actions act = new Actions(driver);
	  act.sendKeys(driver.findElement(cl.amail_element), eml).build().perform();
	  Thread.sleep(2000);
	}
	

    @Given("^I login to Agents portal with Emailid as \"([^\"]*)\"$")
    public void agentsLogin(String amail)

    {
	   driver.findElement(cl.account_button).click();
	   driver.findElement(cl.agents_login_link).click();
	   //Get current window handle
	   String mainWindowHandle = driver.getWindowHandle();
	   //get all window handles
	   Set<String> allWindowHandles = driver.getWindowHandles();
	   Iterator<String> I1= allWindowHandles.iterator();

		    while(I1.hasNext())
		    {

		    String new_window=I1.next();


		    if(!mainWindowHandle.equals(new_window))
		    {
		    	//switch to next tab/window
		    driver.switchTo().window(new_window);
		    driver.findElement(cl.email_element).sendKeys(amail);
		    }
		    }  
    }

    	@Given("^I login to Supplier portal with Emailid as \"([^\"]*)\"$")
    	public void supplierLogin(String smail) 
    	{
	        driver.findElement(cl.account_button).click();
			driver.findElement(cl.supplier_login_link).click();
			//get current window handle
			String mainWindowHandle = driver.getWindowHandle();
			//get all windoe handles
		    Set<String> allWindowHandles = driver.getWindowHandles();
		    Iterator<String> I1= allWindowHandles.iterator();

		    while(I1.hasNext())
		    {

		    String new_window=I1.next();


		    if(!mainWindowHandle.equals(new_window))
		    {
		    	//switch to next window
		    driver.switchTo().window(new_window);
		    driver.findElement(cl.amail_element).sendKeys(smail);
		    }

		    }
		
		    
}
@When("^I enter the password as \"([^\"]*)\"$")
public void i_enter_admin_password_as(String apass) throws InterruptedException  
{
	  Actions act = new Actions(driver);
	  act.sendKeys(driver.findElement(cl.apwd_element), apass).build().perform();
	  Thread.sleep(2000);
}

@When("^I click Admin Login button$")
public void i_click_Admin_Login_button() throws InterruptedException 
{
  
      Actions act = new Actions(driver);
	  act.click(driver.findElement(cl.alogin_button)).build().perform();
	  Thread.sleep(2000);
}

@When("^I enter password as \"([^\"]*)\"$")
public void i_enter_password_as(String pwd)
{
	
	    driver.findElement(cl.password_element).sendKeys(pwd);
}
@When("^I click Login button$")
public void i_click_Login_button() throws InterruptedException {
		driver.findElement(cl.login_button).click();
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(5000);
  }

   @Then("^I should see customer name$")

	public void i_should_see_customer_name()
	{
	   cname = driver.findElement(cl.customer_name).getText();
	   
	}


   @When("^I click My Profile$")

	public void i_click_my_profile()
	{
	
	  driver.findElement(cl.myprofile).click();
	}

	@Then("^validate First Name and customer name present in the dashboard are same$")
	public boolean validate_customer_name()
	{
	    pname = driver.findElement(profile.fname).getAttribute("value");
	    if(cname.toLowerCase().contains(pname))
	    {
	    	return true;
	    	
	    }
	    else
	    {
	    	return false;
	    }
	}

	
	@When("^I click Logout$")
	public void logout()
	
	{
	
		driver.findElement(cl.logout_link).click();
	}

@Then("^I should see Customer Login page$")
public boolean i_should_see_Customer_Login_page()  {
   if(driver.getCurrentUrl().toLowerCase().contains("login"))
   {
	   return true;
   }
   else
   {
	   return false;
   }
   
}

@Then("^I validate error message$")
public boolean isErrorMsgDisplayed() throws Throwable {
    if(driver.findElement(cl.err_msg).getText().toLowerCase().contains("invalid"))
    {
    	return true;
    }
    else
    {
    	return false;
    }
    
}

@Then("^I validate the error message displayed$")
public boolean valErrorMesDisplayed()
{
	  if(driver.findElement(cl.err_msg_supplier).getText().toLowerCase().contains("wrong"))
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
}


@When("^I edit my First Name as \"([^\"]*)\"$")
public void editFName(String nfname) throws InterruptedException 
{
WebElement firstname = driver.findElement(profile.fname);
firstname.clear();

firstname.sendKeys(nfname);


}

@When("^I edit my Last Name as \"([^\"]*)\"$")
public void editLName(String nlname) throws InterruptedException  {
	WebElement lastname = driver.findElement(profile.lname);
	lastname.clear();

	lastname.sendKeys(nlname);
	
}

@When("^I edit my Phone as \"([^\"]*)\"$")
public void editPhone(String ph) throws Throwable {
	WebElement phonenum = driver.findElement(profile.phone);
	phonenum.clear();
	
	phonenum.sendKeys(ph);

}

@When("^I enter my country as \"([^\"]*)\"$")
public void editCountry(String country) throws InterruptedException 
{
	WebElement countryname = driver.findElement(profile.country);
	countryname.click();
	countryname.sendKeys(country);
	countryname.sendKeys(Keys.DOWN);
	Thread.sleep(3000);
	countryname.sendKeys(Keys.ENTER);
	Thread.sleep(3000);
}

@When("^I enter my State as \"([^\"]*)\"$")
public void enterState(String st) throws InterruptedException 
{
	WebElement statename = driver.findElement(profile.state);
	statename.clear();
	statename.sendKeys(st); 

}

@When("^I enter my city as \"([^\"]*)\"$")
public void enterCity(String cty) throws InterruptedException {
	WebElement cityname = driver.findElement(profile.city);
	cityname.clear();
	cityname.sendKeys(cty);
	
}

@When("^I enter my Fax as \"([^\"]*)\"$")
public void enterFax(String fx) throws InterruptedException {
	WebElement fax = driver.findElement(profile.fax);
	fax.clear();
	fax.sendKeys(fx);

}

@When("^I enter my Postal code as \"([^\"]*)\"$")
public void enterPostalCode(String code) throws InterruptedException
{
	WebElement postalcode = driver.findElement(profile.postal);
	postalcode.clear();
	postalcode.sendKeys(code);
	
}



@When("^I enter my address as \"([^\"]*)\"$")
public void enterAddress(String addr) throws InterruptedException {
	WebElement address = driver.findElement(profile.address);
	address.clear();
	address.sendKeys(addr);
	
}


@When("^I click Update Profile button$")
public void clickUpdateProfile() throws InterruptedException
{

	Actions a = new Actions(driver);
	a.sendKeys(Keys.ENTER).build().perform();
	}

@Then("^I validate profile updated success message as \"([^\"]*)\"$")
public boolean validateSuccessMessage(String successmsg) 
{
  if(driver.findElement(profile.success_msg).getText().equalsIgnoreCase(successmsg))
  {
	  return true;
  }
  else
  {
	  return false;
  }
}
@When("^I click Hotels tab$")
public void clickHotels() throws InterruptedException
{
driver.findElement(hb.hotel_link).click();
Thread.sleep(3000);
}

@When("^select \"([^\"]*)\" from the dropdown$")
public void selectCity(String cty) throws InterruptedException 
{
 WebElement sh =driver.findElement(hb.search);
 sh.click();
 
  Actions a = new Actions(driver);
	a.sendKeys(sh,cty).build().perform();
	Thread.sleep(10000);
	a.sendKeys(Keys.ENTER).build().perform();
	Thread.sleep(3000);
	
}

@When("^select \"([^\"]*)\" date from the checkin date picker$")
public void selectCheckinDate(String checkin) throws InterruptedException
{
	try
	{
	WebElement chekin = driver.findElement(hb.checkin_dp);
	chekin.click();
	Thread.sleep(2000);
	
	String[] temp = checkin.split("-");
	String date = temp[0];
	String month_year = temp[1];
	System.out.println(date);
	System.out.println(month_year);
	String calmonth_year = driver.findElement(hb.checkin_cal).getText();
	System.out.println(calmonth_year);
	
	
	while(!calmonth_year.equalsIgnoreCase(month_year))		
	{
		driver.findElement(hb.checkin_next).click();
		calmonth_year = driver.findElement(hb.checkin_cal).getText();
		System.out.println(calmonth_year);
	}
	
	WebElement calmy = driver.findElement(hb.checkintable);
	List<WebElement> rows,cols;
	
	rows = calmy.findElements(hb.checkrow);
	
	for(int i=1;i<rows.size();i++)
	{
		cols = rows.get(i).findElements(hb.checkcol);
		
		for(WebElement element : cols)
		{
			if(element.getText().equals(date))
			{
				element.click();
				break;
			}
		}
	}
	}catch(org.openqa.selenium.StaleElementReferenceException ex)
	{
		//System.out.println("exception");
	}
}

@When("^select \"([^\"]*)\" date from the checkout date picker$")
public void selectCheckoutDate(String chekout)  
{
	try{
		
		String[] ctemp = chekout.split("-");
		String dt = ctemp[0];
		String m_y= ctemp[1];
		

		String cmonth_year = driver.findElement(hb.checkout_cal).getText();

		
		while(!cmonth_year.equalsIgnoreCase(m_y))			
		{
			driver.findElement(hb.checkout_next).click();
			cmonth_year = driver.findElement(hb.checkout_cal).getText();
		}
		WebElement caldate = driver.findElement(hb.checkouttable);
		List<WebElement> row,col;
		
		row = caldate.findElements(hb.checkrow);
		
		for(int i=1;i<row.size();i++)
		{
			col = row.get(i).findElements(hb.checkcol);
			
			for(WebElement elements : col)
			{
				if(elements.getText().equals(dt))
				{
					elements.click();
					break;
				}
			}
		}
		}catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			//System.out.println("exception");
		}
}


@When("^add room count \"([^\"]*)\"$")
public void addRooms(int roomcount) 
{
	driver.findElement(hb.room_dropdown).click();
	String val = driver.findElement(hb.room).getAttribute("value");
	int roomvalue=Integer.parseInt(val);
	
	
	while(roomvalue<roomcount)
	{
		driver.findElement(hb.roominc).click();
	roomvalue++;
	}    
}
@When("^add adults count \"([^\"]*)\"$")
public void addAdults(int adcount) 
{
	
	String adval = driver.findElement(hb.adult).getAttribute("value");
	int adultvalue=Integer.parseInt(adval);
	
	
	while(adultvalue<adcount)
	{
		driver.findElement(hb.adultinc).click();
	adultvalue++;
	}    
}
@When("^add child count \"([^\"]*)\"$")
public void addChild(int chcount) 
{

	String cval = driver.findElement(hb.child).getAttribute("value");
	int childvalue=Integer.parseInt(cval);
	
	
	while(childvalue<chcount)
	{
		driver.findElement(hb.childinc).click();
childvalue++;
	}    
}



@When("^select child age \"([^\"]*)\"$")
public void selectAge(String age) 
{
	Select childage = new Select(driver.findElement(hb.ages));
	childage.selectByVisibleText(age);  
}

@When("^select nation \"([^\"]*)\"$")
public void selectNation(String age) throws InterruptedException 
{
String nation = "India";
Select n = new Select(driver.findElement(hb.nationn));
n.selectByVisibleText(nation);
Thread.sleep(2000);
}

@When("^click on search icon$")
public void clickHotelSearch() 
{
	driver.findElement(hb.search_button).click();
}

@When("^click on Details button of the hotel to view more details$")
public void clickDetails() 
{
	driver.findElement(hb.details).click();
}

@When("^click Book Now button against the preffered room type$")
public void clickBook() throws InterruptedException 
{
	JavascriptExecutor js = ((JavascriptExecutor) driver);
	
	
	js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(hb.scroll_ele));
	Thread.sleep(5000);
	Actions act = new Actions(driver);
	
	act.click(driver.findElement(hb.book_button)).build().perform();
}

@When("^Fill Travellers Information$")
public void fill_Travellers_Information() 
{
	Select tit = new Select(driver.findElement(hb.t1));
    tit.selectByVisibleText("MRS");
    driver.findElement(hb.fname1).sendKeys("Ranjitha");
    driver.findElement(hb.lname1).sendKeys("Malayath");
    
    Select tit2 = new Select(driver.findElement(hb.t2));
    tit2.selectByVisibleText("MR");
    driver.findElement(hb.fname2).sendKeys("Nidhish");
    driver.findElement(hb.lname2).sendKeys("Malayath");
    
}

@When("^select Payment Method$")
public void select_Payment_Method() throws InterruptedException 
{
	
	JavascriptExecutor js1 = ((JavascriptExecutor) driver);
	js1.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(hb.scroll_bank));
	Thread.sleep(5000);
    driver.findElement(hb.bank_t).click();
}

@When("^click T&C checkbox$")
public void clickCheckbox() throws InterruptedException 
{
	driver.findElement(hb.agreecb).click();
	Thread.sleep(2000);
}

@When("^click Confirm Booking$")
public void click_Confirm_Booking() throws InterruptedException 
{
	driver.findElement(hb.booking_button).click();
	Thread.sleep(2000);
	
	
}





@When("^I click My Bookings$")
public void i_click_My_Bookings() throws InterruptedException 
{
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(hb.accounts_top));
	
	driver.findElement(hb.accounts_top).click();
	Thread.sleep(3000);
    driver.findElement(hb.mybookings).click();
    Thread.sleep(2000);
    

}



@When("^I click on View Voucher$")
public void i_click_on_View_Voucher() 
{
    driver.findElement(hb.viewvoucher).click();
}



@Then("^validate booking details$")
public void validate_booking_details() 
{
	String mainWindowHandle = driver.getWindowHandle();
    Set<String> allWindowHandles = driver.getWindowHandles();
    Iterator<String> I1= allWindowHandles.iterator();

    while(I1.hasNext())
    {

    String new_window=I1.next();


    if(!mainWindowHandle.equals(new_window))
    {
    driver.switchTo().window(new_window);
    }

    }
    //switch to the parent window
    driver.switchTo().window(mainWindowHandle);
	
	
	      
}
	
}
