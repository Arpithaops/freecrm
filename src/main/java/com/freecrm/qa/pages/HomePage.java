package com.freecrm.qa.pages;

import java.awt.event.ActionListener;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.freecrm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	
	@FindBy(linkText="Home")
	WebElement home_tab;
	
	@FindBy(xpath="//*[@id=\"top-header-menu\"]/div[2]/span[1]")
	WebElement username_display;
	
	@FindBy(id="top-header-menu")
	WebElement logo;
	
	@FindBy(linkText="Calendar")
	WebElement calendar_tab;
	
	@FindBy(linkText="Contacts")
	WebElement contacts_tab;
	
	@FindBy(linkText="Companies")
	WebElement companies_tab;
	
	@FindBy(linkText="Deals")
	WebElement deals_tab;
	
	@FindBy(linkText="Tasks")
	WebElement tasks_tab;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public ContactsPage clickOnContactstab() {
		contacts_tab.click();
		//contacts_newbtn.click();
		return new ContactsPage();
	}
	
	public CompaniesPage clickOnCompanies() {
		companies_tab.click();
		return new CompaniesPage();
	}
	
	public DealsPage clickOnDeals() {
		deals_tab.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasks() {
		tasks_tab.click();
		return  new TasksPage();
	}
	
	public boolean UsernameDisplay() {
		return username_display.isDisplayed();
		
		
	}
	
	public String TitleDisplay() {
		return driver.getTitle();
	}
	
	public void validateLogo() {
		logo.isDisplayed();
	}

}
