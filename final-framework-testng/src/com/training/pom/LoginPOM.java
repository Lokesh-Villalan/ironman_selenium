package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn; 
	
	@FindBy(id="input-name")
	private WebElement cusName;
	
	@FindBy(id="input-email")
	private WebElement emailId;
	
	@FindBy(id="button-filter")
	private WebElement filter;
	
	
	
	@FindBy(xpath="//input[@value=185]")
	private WebElement checkbox;
	
	@FindBy(xpath="//button[@type='button']//i[@class='fa fa-trash-o']")
	private WebElement delete;
	
	
	
	
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void sendCusName(String cusName) {
		this.cusName.clear();
		this.cusName.sendKeys(cusName);
}
	public void sendEmailId(String emailId) {
		this.emailId.clear();
		this.emailId.sendKeys(emailId);
}
	
	public void clickFilterBtn() {
		this.filter.click(); 
	}
	
	public void clickCheckboxBtn() {
		this.checkbox.click(); 
	}
	
	public void clickDeleteBtn() {
		this.delete.click(); 
	}
}