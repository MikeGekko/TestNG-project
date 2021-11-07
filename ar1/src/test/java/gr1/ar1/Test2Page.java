package gr1.ar1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Test2Page {
	WebDriver driver;
	String url = "https://www.redmine.org/account/register";
	redmineorgPage rp;
	String testResult;
	public static String[] datalog = new String[6];
	
	public Test2Page (WebDriver driver){
		this.driver=driver;
		driver.get(url);
		this.rp = new redmineorgPage(driver);
		PageFactory.initElements(driver, this);
	}
	

	public void log_data() throws FilloException {
		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection("..\\ar1\\src\\login_data.xlsx");
		String strQuery="Select * from login1";
		Recordset rs = connection.executeQuery(strQuery);
		int i=0;
		while(rs.next()) {
			datalog[i] = rs.getField("LOGIN");
			i++;
		}
		rs.close();
		connection.close();
	}
	

	public void resultTest2Write() throws FilloException {
		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection("..\\ar1\\src\\login_data.xlsx");
		String strQuery;
		strQuery= testResult;
		connection.executeUpdate(strQuery);
		connection.close();
	}
	
	public void checkResult(String test) {
		if(rp.falsereg.getText().contains(test)) {
			testResult = "INSERT INTO res2(RESULTS) VALUES('test false')";
		}
		else {
			testResult = "INSERT INTO res2(RESULTS) VALUES('test true')";
		}
	}
	
	public void register1() throws FilloException {
		this.log_data();
		rp.loginInput.sendKeys(datalog[0]);
		rp.submitButt.click();
	}
	public void register2() throws FilloException {
		this.log_data();
		rp.passInput.sendKeys(datalog[1]);
		rp.pass2Input.sendKeys(datalog[1]);
		rp.submitButt.click();
	}
	public void register4() throws FilloException {
		this.log_data();	
		rp.nameInput.sendKeys(datalog[2]);
		rp.submitButt.click();
	}
	public void register5() throws FilloException {
		this.log_data();
		rp.lastnameInput.sendKeys(datalog[3]);
		rp.submitButt.click();
	}
	public void register6() throws FilloException {
		this.log_data();
		rp.emailInput.sendKeys(datalog[4]);
		rp.submitButt.click();
	}
	public void register7() throws FilloException {
		this.log_data();
		rp.nickInput.sendKeys(datalog[5]);
		rp.submitButt.click();
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
