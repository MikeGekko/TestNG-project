package gr1.ar1;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class redmineorgPage {
	private WebDriver driver;
	String url = "https://www.redmine.org/account/register";
	
	@FindBy(xpath="//a[@class='home']")
	WebElement home;
	@FindBy(xpath="//a[@class='projects']")
	WebElement projects;
	@FindBy(xpath="//a[@class='help']")
	WebElement help;
	@FindBy(xpath="//a[@class='login']")
	WebElement log;
	@FindBy(xpath="//a[@class='register']")
	WebElement reg;
	
	@FindBy(xpath="//input[@id='user_login']")
	WebElement loginInput;
	@FindBy(id="user_password")
	WebElement passInput;
	@FindBy(id="user_password_confirmation")
	WebElement pass2Input;
	@FindBy(id="user_firstname")
	WebElement nameInput;
	@FindBy(id="user_lastname")
	WebElement lastnameInput;
	@FindBy(id="user_mail")
	WebElement emailInput;
	@FindBy(id="user_custom_field_values_3")
	WebElement nickInput;
	@FindBy(xpath="//input[@type='submit']")
	WebElement submitButt;
	@FindBy(id="flash_notice")
	WebElement label;
	@FindBy(xpath="//div[@id='flash_notice']")
	WebElement truereg;
	@FindBy(xpath="//div[@id='errorExplanation']")
	WebElement falsereg;

	
	
	public redmineorgPage (WebDriver driver){
		 this.driver=driver;
		 driver.get(url);
		 PageFactory.initElements(driver, this);
	}
		 
	 public void homeClick() {
		 home.click();
	 }
	 
	 public void projClick() {
		 projects.click();
	 }
	
	 public void helpClick() {
		 help.click();
	 }
	 
	 public void logClick() {
		 log.click();
	 }
	 
	 public void regClick() {
		 reg.click();
	 }
	
}
