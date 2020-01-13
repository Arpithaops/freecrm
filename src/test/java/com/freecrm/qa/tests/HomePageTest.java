package com.freecrm.qa.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	
	 
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	@Test(priority=1)
	public void  validateUsername() {
		//boolean htitle=homepage.UsernameDisplay();
		//assert.assertEquals(htitle, "Arpitha Kantareddy");
		Assert.assertTrue(homepage.UsernameDisplay(), "username is not displayed");
		
	}
	
	@Test(priority=2)
	public void validatePageTitle() {
		homepage.TitleDisplay();
	}
	
	@Test(priority=3)
	public void validateLogo() {
		homepage.validateLogo();
	}
	
	@AfterMethod
	public void CloseBrowser() {
		driver.quit();
	}

}
