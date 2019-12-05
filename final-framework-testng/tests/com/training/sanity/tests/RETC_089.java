package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOMRS;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_089 {
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
		WebElement properties=driver.findElement(By.xpath("//div[contains(text(),'Properties')]"));
		Actions action =new Actions(driver);//action class used to do keyboard and mouse action in selenium
		action.moveToElement(properties).build().perform();//this line - do mouse hover on the particular element
		Thread.sleep(2000);
		//WebElement sales=driver.findElement(By.xpath("//a[@class='parent']//*[contains(text(),'Sales')]"));
		//a[contains(text()[1],'Sales')]
		WebElement regions=driver.findElement(By.xpath("//a[contains(text(),'Regions')]"));
		Thread.sleep(4000);
		action.moveToElement(regions).click().perform();
		Thread.sleep(3000);
		/*WebElement order=driver.findElement(By.xpath("/html/body/div[1]/nav/ul/li[10]/ul/li[1]/ul/li[1]/a"));
		Thread.sleep(2000);
		action.moveToElement(order).click().perform();
		Thread.sleep(3000);*/
		
		loginPOMRS.sendFeatureName("Koramangala22");
		Thread.sleep(3000);
		
		loginPOMRS.sendSlugName("East");
		Thread.sleep(3000);
		
		WebElement product =driver.findElement(By.xpath("//select[@id='parent']"));
		Select selectProduct = new Select(product);
		selectProduct.selectByIndex(3);
		//selectProduct.selectByVisibleText("East Bangalore");
		Thread.sleep(3000);
		
		loginPOMRS.sendDescName("Koramangala sony signal");
		Thread.sleep(3000);
		
		loginPOMRS.clickaddNewRegionBtn(); 
		Thread.sleep(3000);
		
		loginPOMRS.clickPropertiesBtn();
		Thread.sleep(3000);
		loginPOMRS.clickaddNewLinkBtn();
		Thread.sleep(3000);
		loginPOMRS.sendTitle("shantiniketan28");
		Thread.sleep(3000);
		loginPOMRS.sendTextArea("flat");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='in-region-58']")).click();
		//loginPOMRS.clickCheckboxBtn();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,0)");
		loginPOMRS.clickPublishBtn();
		Thread.sleep(3000);
		
		/*WebElement logout=driver.findElement(By.xpath("//a[contains(text(),'Howdy')]"));
		Actions action =new Actions(driver);//action class used to do keyboard and mouse action in selenium
		action.moveToElement(logout).build().perform();//this line - do mouse hover on the particular element
		Thread.sleep(2000);
		//WebElement sales=driver.findElement(By.xpath("//a[@class='parent']//*[contains(text(),'Sales')]"));
		//a[contains(text()[1],'Sales')]
		WebElement logoutbtn=driver.findElement(By.xpath("//a[@class='ab-item'][contains(text(),'Log Out')]"));
		Thread.sleep(4000);
		action.moveToElement(logoutbtn).click().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Real Estate']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@title='Search input']")).sendKeys("Pristege28");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='asl_res_url'][contains(text(),'Pristege28')]")).click();
		Thread.sleep(3000);*/
		
	}
}
