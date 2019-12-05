package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOMRS {
private WebDriver driver; 
	
	public LoginPOMRS(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(xpath="//input[@name='login']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//div[contains(text(),'Properties')]")
	private WebElement properties;
	
	
	
	@FindBy(xpath="//a[@class='page-title-action']")
	private WebElement addNewLink;
	
	@FindBy(xpath="//input[@name='post_title']")
	private WebElement title;
	
	@FindBy(id="button-filter")
	private WebElement filter;
	
	
	
	@FindBy(xpath="//input[@value=185]")
	private WebElement checkbox;
	
	@FindBy(xpath="//button[@type='button']//i[@class='fa fa-trash-o']")
	private WebElement delete;
	
	
	@FindBy(id="tag-name")
	private WebElement featureName;
	
	@FindBy(id="tag-slug")
	private WebElement slugName;
	
	@FindBy(id="tag-description")
	private WebElement descName;
	
	@FindBy(id="tag-name")
	private WebElement newFeature;
	
	@FindBy(id="submit")
	private WebElement addNewRegion;
	
	
	@FindBy(id="_price")
	private WebElement price;
	
	public void sendPrice(String price) {
		this.price.clear();
		this.price.sendKeys(price);
	}
	
	@FindBy(id="_price_per")
	private WebElement priceSqm;
	
	public void sendPriceSqm(String priceSqm) {
		this.priceSqm.clear();
		this.priceSqm.sendKeys(priceSqm);
	}
	
	@FindBy(id="ui-id-2")
	private WebElement mainDetails;
	
	public void clickmainDetailsBtn() {
		this.mainDetails.click(); 
	}
	
	@FindBy(id="_status")
	private WebElement status;
	
	public void sendStatus(String status) {
		this.status.clear();
		this.status.sendKeys(status);
	}
	
	@FindBy(id="_location")
	private WebElement location;
	
	public void sendLocation(String location) {
		this.location.clear();
		this.location.sendKeys(location);
	}
	
	@FindBy(id="_possession")
	private WebElement possession;
	
	public void sendPossession(String possession) {
		this.possession.clear();
		this.possession.sendKeys(possession);
	}
	
	@FindBy(id="ui-id-3")
	private WebElement locTab;
	
	public void clicklocTabBtn() {
		this.locTab.click(); 
	}
	
	
	
	@FindBy(id="_friendly_address")
	private WebElement address;
	
	public void sendAddress(String address) {
		this.address.clear();
		this.address.sendKeys(address);
	}
	
	@FindBy(id="_address")
	private WebElement googlemap;
	
	public void sendGooglemap(String googlemap) {
		this.googlemap.clear();
		this.googlemap.sendKeys(googlemap);
	}
	
	@FindBy(id="_geolocation_lat")
	private WebElement lat;
	
	public void sendLat(String lat) {
		this.lat.clear();
		this.lat.sendKeys(lat);
	}
	@FindBy(id="_geolocation_long")
	private WebElement lon;
	
	public void sendLon(String lon) {
		this.lon.clear();
		this.lon.sendKeys(lon);
	}
	
	@FindBy(id="ui-id-4")
	private WebElement details;
	
	public void clickdetailsBtn() {
		this.details.click(); 
	}
	
	
	
	@FindBy(id="_storage_room")
	private WebElement storageroom;
	
	public void sendStorageroom(String storageroom) {
		this.storageroom.clear();
		this.storageroom.sendKeys(storageroom);
	}
	
	
	
	
	
	@FindBy(xpath="//input[@id='publish']")
	private WebElement publish;
	
	@FindBy(xpath="//textarea[@id='content']")
	private WebElement textArea;
	
	@FindBy(xpath="//input[@id='in-property_feature-416']")
	private WebElement checkBox;
	
	public void sendTextArea(String textArea) {
		this.textArea.clear();
		this.textArea.sendKeys(textArea);
	}
	
	
	public void sendSlugName(String slugName) {
		this.slugName.clear();
		this.slugName.sendKeys(slugName);
	}
	
	public void sendDescName(String descName) {
		this.descName.clear();
		this.descName.sendKeys(descName);
	}
	
	public void sendFeatureName(String featureName) {
		this.featureName.clear();
		this.featureName.sendKeys(featureName);
	}
	
	public void clicknewFeatureBtn() {
		this.newFeature.click(); 
	}
	
	public void clickaddNewRegionBtn() {
		this.addNewRegion.click(); 
	}
	
	public void clickcheckBoxBtn() {
		this.checkBox.click(); 
	}
	
	public void clickPublishBtn() {
		this.publish.click(); 
	}
	
	
	
	
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
	
	public void clickPropertiesBtn() {
		this.properties.click(); 
	}
	
	public void clickaddNewLinkBtn() {
		this.addNewLink.click(); 
	}
	public void sendTitle(String title) {
		this.title.clear();
		this.title.sendKeys(title);
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
