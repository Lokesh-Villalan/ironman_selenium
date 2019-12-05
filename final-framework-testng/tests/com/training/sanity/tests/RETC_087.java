package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LoginPOMRS;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_087 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOMRS loginPOMRS;
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
		loginPOMRS = new LoginPOMRS(driver); 
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
		
		
	
		loginPOMRS.sendUserName("admin");
		loginPOMRS.sendPassword("admin@123");
		loginPOMRS.clickLoginBtn(); 
		Thread.sleep(2000);
		/*WebElement properties=driver.findElement(By.xpath("//div[contains(text(),'Properties')]"));
		Actions action =new Actions(driver);//action class used to do keyboard and mouse action in selenium
		action.moveToElement(properties).build().perform();//this line - do mouse hover on the particular element
		Thread.sleep(2000);
		//WebElement sales=driver.findElement(By.xpath("//a[@class='parent']//*[contains(text(),'Sales')]"));
		//a[contains(text()[1],'Sales')]
		WebElement features=driver.findElement(By.xpath("//a[contains(text(),'Features')]"));
		Thread.sleep(4000);
		action.moveToElement(features).click().perform();
		Thread.sleep(3000);
		WebElement order=driver.findElement(By.xpath("/html/body/div[1]/nav/ul/li[10]/ul/li[1]/ul/li[1]/a"));
		Thread.sleep(2000);
		action.moveToElement(order).click().perform();
		Thread.sleep(3000);
		
		loginPOMRS.sendFeatureName("New Launches");
		Thread.sleep(3000);
		
		loginPOMRS.sendSlugName("launch");
		Thread.sleep(3000);
		
		loginPOMRS.sendDescName("New Launches of vilas, apartments, flats");
		Thread.sleep(3000);
		
		loginPOMRS.clicknewFeatureBtn(); 
		Thread.sleep(3000);*/
		
		loginPOMRS.clickPropertiesBtn();
		Thread.sleep(3000);
		loginPOMRS.clickaddNewLinkBtn();
		Thread.sleep(3000);
		loginPOMRS.sendTitle("New Launches2");
		Thread.sleep(3000);
		loginPOMRS.sendTextArea("launch1");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='in-property_feature-416']")).click();
		//loginPOMRS.clickCheckboxBtn();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,0)");
		loginPOMRS.clickPublishBtn();
		Thread.sleep(3000);
	}
}
