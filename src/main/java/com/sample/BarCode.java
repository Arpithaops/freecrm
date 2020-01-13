package com.sample;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class BarCode {
	public static void main(String args[]) throws IOException, NotFoundException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Softwares\\Chrome\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();		
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://testautomationpractice.blogspot.com/");
		
		String barcodeurl=driver.findElement(By.xpath("//*[@id=\"HTML12\"]/div[1]/img[2]")).getAttribute("src");
		
		URL url=new URL(barcodeurl);
		
		BufferedImage bufferedimage=ImageIO.read(url);
		
		LuminanceSource luminancesource=new BufferedImageLuminanceSource(bufferedimage);
		
		BinaryBitmap bitmap=new BinaryBitmap(new HybridBinarizer(luminancesource));
		
		Result result=new MultiFormatReader().decode(bitmap);
		
		System.out.println(result.getText());
		
		driver.close();
	}

}
