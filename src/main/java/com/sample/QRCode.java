package com.sample;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
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


public class QRCode {
	
	public static void main(String args[]) throws IOException, NotFoundException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Softwares\\Chrome\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();		
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.qr-code-generator.com/");
		
		String qrcode=driver.findElement(By.xpath("//*[@id=\"frameBody\"]/img")).getAttribute("src");
		
		URL url=new URL(qrcode);
		
		BufferedImage bufferedimage=ImageIO.read(url);
		
		LuminanceSource luminancesource=new BufferedImageLuminanceSource(bufferedimage);
		
		BinaryBitmap binarybitmap=new BinaryBitmap(new HybridBinarizer(luminancesource));
		
		Result result=new MultiFormatReader().decode(binarybitmap);
		
		System.out.println(result.getText());
		
		driver.close();
		
	}

}
