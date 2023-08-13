package com.staragile.selenium.demo.maven_selenium_insureme;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class InsuremeSelenium
{
    public static void main( String[] args ) throws InterruptedException, IOException
    {
    	System.setProperty("webdriver.chrome.driver", "/home/ubuntu/chrome-linux64");
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriver driver = new ChromeDriver(chromeOptions);
		chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
		driver.get("http://18.188.75.52:8084//contact.html");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.id("inputName")).sendKeys("sivabalan");
		driver.findElement(By.id("inputNumber")).sendKeys("8903780909");
		driver.findElement(By.id("inputMail")).sendKeys("sivabalana91@gmail.com");
		driver.findElement(By.id("inputMessage")).sendKeys("Hello siva, Welcome to insureme");
		driver.findElement(By.id("my-button")).click();
		
		String message = driver.findElement(By.id("response")).getText();
		if(message.equals("Message Sent")){
			System.out.println("Script executed sucessfully");
		}else {
			System.out.println("Automation script failed");
		}
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("/home/ubuntu/insureme.png");
		FileUtils.copyFile(screenShot, destFile);
		
		Thread.sleep(3000);
		driver.close();
    }
}
