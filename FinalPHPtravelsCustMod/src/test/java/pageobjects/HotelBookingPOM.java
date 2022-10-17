package pageobjects;

import org.openqa.selenium.By;

public class HotelBookingPOM 
{

	public By hotel_link= By.linkText("Hotels");
	public By search = By.xpath("//span[@aria-labelledby='select2-hotels_city-container' and @class ='select2-selection select2-selection--single']");
	
	public By checkin_dp = By.id("checkin");
	public By checkin_cal = By.className("switch");
	public By checkin_next= By.className("next");
	public By checkintable= By.className("table-condensed");
	public By checkrow= By.tagName("tr");
	public By checkcol = By.tagName("td");
	
	public By checkout_cal= By.xpath("/html/body/div[7]/div[1]/table/thead/tr[1]/th[2]");
	public By checkout_next= By.xpath("/html/body/div[7]/div[1]/table/thead/tr[1]/th[3]");
	public By checkouttable= By.xpath("/html/body/div[7]/div[1]/table");
	
	public By room_dropdown = By.xpath("//*[@id='hotels-search']/div/div/div[3]/div/div/div/a");
	public By room = By.id("rooms");
	public By roominc = By.className("roomInc");
	public By adult = By.id("adults");
	public By adultinc = By.xpath("/html/body/section[1]/section/div/div/form/div/div/div[3]/div/div/div/div/div[2]/div/div/div[2]");
	public By child = By.id("childs");
	public By childinc = By.xpath("/html/body/section[1]/section/div/div/form/div/div/div[3]/div/div/div/div/div[3]/div/div/div[2]");
    public By ages = By.id("ages1");
    public By nationn = By.id("nationality");
    public By search_button = By.id("submit");
    public By details = By.xpath("/html/body/section[2]/div/div/div[2]/section/ul/li[2]/div/div[2]/div/div[2]/div/a");
  
    public By book_button =By.xpath("/html/body/section[1]/div[3]/div/div/div[1]/div[1]/div[3]/div[2]/div/div[2]/form/div/div[5]/div/button");
    public By t1=By.name("title_1");
    public By fname1 = By.name("firstname_1");
    public By lname1=By.name("lastname_1");
    public By t2=By.name("title_2");
    public By fname2 = By.name("firstname_2");
    public By lname2=By.name("lastname_2");
    public By scroll_bank = By.xpath("/html/body/div[5]/form/section/div/div/div[1]/div[3]/div[2]/div/ul/label/label/div/div");
    public By bank_t = By.xpath("/html/body/div[5]/form/section/div/div/div[1]/div[3]/div[2]/div/ul/label/label/label/label/label/div/div");
    public By agreecb = By.xpath("/html/body/div[5]/form/section/div/div/div[1]/div[4]/div/div/div/label");
    public By booking_button = By.id("booking");
    public By proceed_button = By.xpath("//input[@value='Proceed']");
    public By back_toinvoice = By.xpath("/html/body/div/div[2]/div[2]");
    public By yes = By.linkText("Yes");
    public By reservation_no1 = By.xpath("/html/body/section[1]/div/div/div/div/div[3]/div[1]/h3/span");
    public By accounts_top = By.xpath("/html/body/header/div/div/div/div/div/div[2]/div/div[2]/div[3]/div/button");
   // public By logo = By.xpath("/html/body/header/div/div/div/div/div/div[1]/a/img");
    public By logo = By.xpath("//img[@src='https://phptravels.net/api/uploads/global/logo.png']");
  
    public By mybookings = By.linkText("My Bookings");
    public By bookingmsg = By.xpath("/html/body/section[1]/div/div/div/div/div[1]");
    public By viewvoucher = By.linkText("View Voucher");
    public By reservation_no2 = By.xpath("/html/body/section[1]/div/div/div/div/div[3]/div[1]/h3/span");
    public By scroll_ele = By.xpath("/html/body/section[1]/div[3]/div/div/div[1]/div[1]/div[2]/div[3]/div[1]/strong");
    

}

