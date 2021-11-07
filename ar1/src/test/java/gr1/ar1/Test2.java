package gr1.ar1;



import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;

public class Test2 {
	WebDriver driver;
	redmineorgPage regPage;
	String result;
	String expectedResult;
	Test2Page test2;
	String testResult;
	String[] test = {"Вхід", "Пароль","Ім'я","Прізвище","Ел. пошта","Nick"};



		@BeforeClass
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
			test2.checkResult(test[0]);
			test2.resultTest2Write();
			assertTrue(regPage.falsereg.isDisplayed());
		}
		@Test
		public void testPassword() throws FilloException, IOException {
			test2.register2();
			test2.takeScreenShots("testPassword");
			test2.checkResult(test[1]);
			test2.resultTest2Write();
			assertTrue(regPage.falsereg.isDisplayed());
		}
		@Test
		public void testFirstName() throws FilloException, IOException {
			test2.register4();
			test2.takeScreenShots("testFirstName");
			test2.checkResult(test[2]);
			test2.resultTest2Write();
			assertTrue(regPage.falsereg.isDisplayed());
		}
		@Test
		public void testLastName() throws FilloException, IOException {
			test2.register5();
			test2.takeScreenShots("testLastName");
			test2.checkResult(test[3]);
			test2.resultTest2Write();
			assertTrue(regPage.falsereg.isDisplayed());
		}
		@Test
		public void testEmail() throws FilloException, IOException {
			test2.register6();
			test2.takeScreenShots("testEmail");
			test2.checkResult(test[4]);
			test2.resultTest2Write();
			assertTrue(regPage.falsereg.isDisplayed());
		}
		@Test
		public void testNick() throws FilloException, IOException {
			test2.register7();
			test2.takeScreenShots("testNick");
			test2.checkResult(test[5]);
			test2.resultTest2Write();
			assertTrue(regPage.falsereg.isDisplayed());
		}
		
}
