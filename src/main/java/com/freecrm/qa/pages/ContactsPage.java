package com.freecrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button")
	WebElement contacts_newbtn;
	
	@FindBy(name="first_name")
	WebElement contacts_new_firstname;
	
	@FindBy(name="last_name")
	WebElement contacts_new_lastname;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/div/div/input")
	WebElement contacts_new_companyname;
	
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[1]")
	WebElement contactsheader;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/thead/tr/th[5]")
	WebElement contacts_email;
	
	@FindBy(linkText="Contacts")
	WebElement contacts_tab;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
		driver.findElement(By.linkText("Contacts")).click();
	}
	
	public void validateContactsHeader() {
	    contactsheader.isDisplayed();
	}
	public void validateEmailTab() {
		contacts_email.isDisplayed();
	}
	

}
