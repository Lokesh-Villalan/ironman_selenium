package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_022 {
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
			
			WebElement reports=driver.findElement(By.xpath("//i[@class='fa fa-bar-chart-o fw']"));
			Actions action =new Actions(driver);//action class used to do keyboard and mouse action in selenium
			action.moveToElement(reports).build().perform();//this line - do mouse hover on the particular element
			Thread.sleep(2000);
			//WebElement sales=driver.findElement(By.xpath("//a[@class='parent']//*[contains(text(),'Sales')]"));
			//a[contains(text()[1],'Sales')]
			WebElement sales=driver.findElement(By.xpath("//a[contains(text()[1],'Sales')]"));
			Thread.sleep(4000);
			action.moveToElement(sales).click().perform();
			Thread.sleep(3000);
			WebElement order=driver.findElement(By.xpath("/html/body/div[1]/nav/ul/li[10]/ul/li[1]/ul/li[1]/a"));
			Thread.sleep(2000);
			action.moveToElement(order).click().perform();
			Thread.sleep(3000);
			WebElement product =driver.findElement(By.id("input-group"));
			Select selectProduct = new Select(product);
			//select methods are used select the element form drop downs
			//selectProduct.selectByIndex(3);
			//selectProduct.selectByVisibleText("Weeks");
			selectProduct.selectByVisibleText("Months");
			Thread.sleep(2000);
			loginPOM.clickFilterBtn();
			Thread.sleep(5000);
			
			
}
}
