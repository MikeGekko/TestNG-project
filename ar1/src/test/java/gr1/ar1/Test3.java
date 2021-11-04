package gr1.ar1;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;


public class Test3 {
	WebDriver driver;
	redmineorgPage regPage;
	String result;
	String expectedResult;
	Test3Page test3;
	String testResult;


		@BeforeTest
		public void setup() {
			 System.setProperty("webdriver.chrome.driver","..\\ar1\\driver\\chromedriver.exe");  
			 driver=new ChromeDriver();
			 driver.manage().window().maximize();
			 regPage = new redmineorgPage(driver);
			 test3 = new Test3Page(driver);
;		}

		@AfterTest
		public void end() {
			driver.quit();
		}
		

		
		@DataProvider (name = "RegisterData")
		public Object[][] exelData() throws FilloException {
			return  test3.logData();
		}
	
		@Test (dataProvider="RegisterData")
		public void testRegister(String login, String password, String FN, String LN, String mail, String nick) throws FilloException {
			test3.register(login, password, FN, LN, mail, nick);
			if (driver.getCurrentUrl().equals("https://www.redmine.org/login"))
			{
				testResult = "INSERT INTO res3(RESULTS) VALUES('test passed')";
			}
			else {
				test3.takeScreenShots("test3Fail");
				testResult = "INSERT INTO res3(RESULTS) VALUES('test NOT passed')";
			}
			test3.resultTest3Write(testResult);
			driver.get("https://www.redmine.org/account/register");
		}
		
}
