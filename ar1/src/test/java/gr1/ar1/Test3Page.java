package gr1.ar1;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Test3Page {
	WebDriver driver;
	String url = "https://www.redmine.org/account/register";
	redmineorgPage rp;
	public static String[][] datalog = new String[3][6];
	
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
	@FindBy(xpath="//div[@id='errorExplanation']")
	WebElement falsereg;
	@FindBy(xpath="//div[@id='flash_notice']")
	WebElement truereg;
	
	public Test3Page (WebDriver driver){
		 this.driver=driver;
		 driver.get(url);
		 PageFactory.initElements(driver, this);
	}
	
	public void resultTest3Write(String testRes) throws FilloException {
		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection("..\\ar1\\src\\login_data.xlsx");
		String strQuery;
		strQuery= testRes;
		connection.executeUpdate(strQuery);
		connection.close();
	}
	
	public String[][] logData() throws FilloException {
		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection("..\\ar1\\src\\login_data.xlsx");
		String strQuery="Select * from Test3";
		Recordset rs = connection.executeQuery(strQuery);
		int i=0;
		while(rs.next()) {
			datalog[i][0] = rs.getField("Login");
			datalog[i][1] = rs.getField("Password");
			datalog[i][2] = rs.getField("FirstName");
			datalog[i][3] = rs.getField("LastName");
			datalog[i][4] = rs.getField("Email");
			datalog[i][5] = rs.getField("Nick");
			i++;
		}
		rs.close();
		connection.close();
		return datalog;
	}

	
	public void register(String login, String password, String FN, String LN, String mail, String nick) {
		String pass = password;
		loginInput.sendKeys(login + getAlphaNumericString(4));
		passInput.sendKeys(pass);
		pass2Input.sendKeys(pass);
		nameInput.sendKeys(FN);
		lastnameInput.sendKeys(LN);
		emailInput.sendKeys(getAlphaNumericString(4) + mail);
		nickInput.sendKeys(nick);
		submitButt.click();

	}
	
	static String getAlphaNumericString(int n)
    {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int)(AlphaNumericString.length()* Math.random()); 
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }
	
	public void takeScreenShots(String screenName) {
        try {
        	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        	FileUtils.copyFile(screenshotFile, new File(".//screenshots//"+screenName+".png"));
        	//System.out.println("screenshot taken");
        } catch (IOException e) {
        	System.out.println("screenshot failed");
        }
	}
}
