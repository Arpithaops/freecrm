package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//PageFactory -OR
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[3]")
	WebElement login_button;
	
	@FindBy(linkText="Sign Up")
	WebElement signUp;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String ValidatePageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String usrnme, String pwd) {
		username.sendKeys(usrnme);
		password.sendKeys(pwd);
		login_button.click();
		
		return new HomePage();
	}

}
