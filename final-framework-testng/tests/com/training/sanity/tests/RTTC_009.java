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

public class RTTC_009 {
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
		Thread.sleep(5000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		//driver.findElement(By.xpath("//a[contains(text(),'Sas')]")).click();
		Thread.sleep(2000);
		//driver.findElement(By.linkText("Finger Ring")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'sofa')]")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.id("button-cart")).click();
		WebElement cart=driver.findElement(By.xpath("//i[@class='tb_icon ico-linea-ecommerce-bag']"));
		Actions action =new Actions(driver);//action class used to do keyboard and mouse action in selenium
		action.moveToElement(cart).build().perform();//this line - do mouse hover on the particular element
		Thread.sleep(8000);
		WebElement viewcart=driver.findElement(By.xpath("//a[@class='btn btn-sm'][contains(text(),'View Cart')]"));
		Thread.sleep(3000);
		action.moveToElement(viewcart).click().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
		Thread.sleep(3000);
		loginPOM.sendUserName("revasharma@gmail.com");
		Thread.sleep(2000);
		loginPOM.sendPassword("reva123");
		Thread.sleep(2000);
		loginPOM.clickLoginBtn(); 
		Thread.sleep(2000);
	
		screenShot.captureScreenShot("First");
	}
}
