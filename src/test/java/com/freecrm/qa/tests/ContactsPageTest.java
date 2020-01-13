package com.freecrm.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		contactspage=new ContactsPage();
	}
	
	@Test
	public void emailHeader() {
		contactspage.validateEmailTab();
	}
	
	@Test
	public void contactsHeader() {
		contactspage.validateContactsHeader();
	}
	
	@AfterMethod
	public void CloseBrowser() {
		driver.quit();
	}
	

}
