package com.freecrm.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		 loginpage=new LoginPage();		
	}
	
	@Test(priority=1)
	public void ValidatePageTitle() {
		String title=loginpage.ValidatePageTitle();
		Assert.assertEquals(title, "CRM");
		
	}
	
	@Test(priority=2)
	public void login() {
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void returnHomePage() {
		driver.quit();
		//driver.findElement(By.linkText("Home")).click();
	}

}
