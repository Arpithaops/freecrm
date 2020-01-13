package com.freecrm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.freecrm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		prop=new Properties();
		try {
			FileInputStream fileinput=new FileInputStream("C:\\QA\\Eclipse projects(old)\\freecrm"+
		"\\src\\main\\java\\com\\freecrm\\qa\\config\\config.properties");		   
			prop.load(fileinput);			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
	    }
    }
	
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\QA\\Softwares\\chromedriver.exe");
			driver=new ChromeDriver();
		} else if(browserName.equals("gecko")){
			System.setProperty("webdriver.gecko.driver", "C:\\QA\\Softwares\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Pageload_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitwait_timeout, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	
}
