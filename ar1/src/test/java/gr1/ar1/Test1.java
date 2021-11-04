package gr1.ar1;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {
	WebDriver driver;
	redmineorgPage regPage;
	String result;
	String expectedResult;

	
	
	
		@BeforeTest
		public void setup() {
			 System.setProperty("webdriver.chrome.driver","..\\\\ar1\\\\driver\\\\chromedriver.exe");  
			 driver=new ChromeDriver();
			 driver.manage().window().maximize();
			 regPage = new redmineorgPage(driver);
		}
	
		@AfterTest
		public void end() {
			driver.quit();
		}
		
		@Test
		public void test1(){
			regPage.homeClick();
			result = driver.getTitle();
			expectedResult = "Overview - Redmine";
			assertTrue(result.equals(expectedResult));
			
		}
		@Test
		public void test2(){	
			regPage.projClick();
			result = driver.getTitle();
			expectedResult = "Проекти - Redmine";
			assertTrue(result.equals(expectedResult));
		}
		@Test
		public void test3(){
			regPage.helpClick();
			result = driver.getTitle();
			expectedResult = "Guide - Redmine";
			assertTrue(result.equals(expectedResult));
		}
		@Test
		public void test4(){
			regPage.logClick();
			result = driver.getTitle();
			expectedResult = "Redmine";
			assertTrue(result.equals(expectedResult));
		}
		@Test
		public void test5(){
			regPage.regClick();
			result = driver.getTitle();
			expectedResult = "Redmine";
			assertTrue(result.equals(expectedResult));
		}		
			
}
