package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_020 {
  
  private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
	
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		Thread.sleep(3000);
		
		WebElement list=driver.findElement(By.xpath("//i[@class='fa fa-user fw']"));
		Actions action =new Actions(driver);//action class used to do keyboard and mouse action in selenium
		action.moveToElement(list).build().perform();//this line - do mouse hover on the particular element
		Thread.sleep(4000);
		WebElement customer=driver.findElement(By.xpath("/html/body/div[1]/nav/ul/li[7]/ul/li[1]/a"));
		Thread.sleep(2000);
		action.moveToElement(customer).click().perform();
		Thread.sleep(3000);
		loginPOM.sendCusName("Harish H");
		Thread.sleep(2000);
		loginPOM.clickFilterBtn();
		Thread.sleep(5000);
		loginPOM.sendEmailId("harishy77@gmail.com");
		Thread.sleep(2000);
		loginPOM.clickFilterBtn();
		
		
		
		//screenShot.captureScreenShot("First");
	}
}
