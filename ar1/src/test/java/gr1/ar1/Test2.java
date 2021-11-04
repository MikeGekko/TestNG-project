package gr1.ar1;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;

public class Test2 {
	WebDriver driver;
	redmineorgPage regPage;
	String result;
	String expectedResult;
	Test2Page test2;
	String testResult;


		@BeforeTest
		public void setup() {
			 System.setProperty("webdriver.chrome.driver","..\\ar1\\driver\\chromedriver.exe");  
			 driver=new ChromeDriver();
			 driver.manage().window().maximize();
			 regPage = new redmineorgPage(driver);
			 test2 = new Test2Page(driver);
;		}

		@AfterTest
		public void end() {
			driver.quit();
		}

		@Test
		public void testLogin() throws FilloException, IOException {
			test2.register1();
			test2.takeScreenShots("testLog");
			if(regPage.falsereg.getText().contains("Вхід")) {
				testResult = "INSERT INTO res2(RESULTS) VALUES('testLogin false')";
			}
			else {
				testResult = "INSERT INTO res2(RESULTS) VALUES('testLogin true')";
			}
			test2.resultTest2Write(testResult);
		}
		@Test
		public void testPassword() throws FilloException, IOException {
			test2.register2();
			test2.resultTest2Write(testResult);
			test2.takeScreenShots("testPassword");
			if(regPage.falsereg.getText().contains("Пароль")) {
				testResult = "INSERT INTO res2(RESULTS) VALUES('testLogin false')";
			}
			else {
				testResult = "INSERT INTO res2(RESULTS) VALUES('testLogin true')";
			}
			test2.resultTest2Write(testResult);
		}
		@Test
		public void testFirstName() throws FilloException, IOException {
			test2.register4();
			test2.takeScreenShots("testFirstName");
			test2.takeScreenShots("testPassword");
			if(regPage.falsereg.getText().contains("Ім'я")) {
				testResult = "INSERT INTO res2(RESULTS) VALUES('testFirstName false')";
			}
			else {
				testResult = "INSERT INTO res2(RESULTS) VALUES('testFirstName true')";
			}
			test2.resultTest2Write(testResult);
		}
		@Test
		public void testLastName() throws FilloException, IOException {
			test2.register5();
			test2.takeScreenShots("testLastName");
			if(regPage.falsereg.getText().contains("Прізвище")) {
				testResult = "INSERT INTO res2(RESULTS) VALUES('testFirstName false')";
			}
			else {
				testResult = "INSERT INTO res2(RESULTS) VALUES('testFirstName true')";
			}
			test2.resultTest2Write(testResult);
		}
		@Test
		public void testEmail() throws FilloException, IOException {
			test2.register6();
			test2.takeScreenShots("testEmail");
			if(regPage.falsereg.getText().contains("Ел. пошта")) {
				testResult = "INSERT INTO res2(RESULTS) VALUES('testFirstName false')";
			}
			else {
				testResult = "INSERT INTO res2(RESULTS) VALUES('testFirstName true')";
			}
			test2.resultTest2Write(testResult);
		}
		@Test
		public void testNick() throws FilloException, IOException {
			test2.register7();
			test2.takeScreenShots("testNick");
			if(regPage.falsereg.getText().contains("Nick")) {
				testResult = "INSERT INTO res2(RESULTS) VALUES('testFirstName false')";
			}
			else {
				testResult = "INSERT INTO res2(RESULTS) VALUES('testFirstName true')";
			}
			test2.resultTest2Write(testResult);
		}
		
}
