package com.ninza.crm.object.repository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ninza.crm.generic.utility.WebDriverUtility;

public class ContactsPage {
	WebDriver driver;
	WebDriverUtility wdUtility;
	
	public ContactsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this); // use the driver to search the elements on this page 
		this.wdUtility= new WebDriverUtility(driver); // initiliaze here so we dont need ini again and again each method	
	}
	
	// click create contact button
	@FindBy(xpath="//span[normalize-space()='Create Contact']")
	private WebElement clickOnCreateContactButton;
	public WebElement getClickOnCreateContactButton() {
		return clickOnCreateContactButton;
	}
	
	// click on Organization input field 
	@FindBy(xpath="//input[@name='organizationName']")
	private WebElement clickOnOrganizationNameInput;
	public WebElement getclickOnOrganizationNameInput() {
		return clickOnOrganizationNameInput;
	}
	//click on title input field 
	@FindBy(xpath="//input[@name='title']")
	private WebElement clickOnTitleInput;
	public WebElement getClickOnTitleInput() {
		return clickOnTitleInput;
	}
	// click on Contact name input field
	@FindBy(xpath="//input[@name='contactName']")
	private WebElement clickOnContactNameInput;
	public WebElement getClickOnContactNameInput() {
		return clickOnContactNameInput;
	}
	// click on Mobile input field 
	@FindBy(xpath="//input[@name='mobile']")
	private WebElement clickOnMobileInput;
	public WebElement getClickOnMobileInput() {
		return clickOnMobileInput;
	}
	// click on Campaign button to select the campaign by name or id 
	@FindBy(xpath="//div[@class='form-group']//button[@type='button']")
	private WebElement clickOnCampaignBtn;
	public WebElement getClickOnCampaignBtn() {
		return clickOnCampaignBtn;
	}
	//select a list from campaign list 
	
	@FindBy(xpath="//tbody/tr[1]/td[7]/button[1]")
	private WebElement clickOnCampaignFromList;
	public WebElement getClickOnCampaignFromList() {
		return clickOnCampaignFromList;
	}
	
	//click on Create contact button 
	@FindBy(xpath="//button[@type='submit']")
	private WebElement clickOnCreateContactBtn;
	public WebElement getClickOnCreateContactBtn() {
		return clickOnCreateContactBtn;
	}
	

	
	
	
	// Business Utility for Create Contact 
	
	public void createContact(String OrgName,String Title,String ContactName,String Mobile) {
		wdUtility = new WebDriverUtility(driver);
		getClickOnCreateContactButton().click();
		getclickOnOrganizationNameInput().sendKeys(OrgName);
		getClickOnTitleInput().sendKeys(Title);
		getClickOnMobileInput().sendKeys(Mobile);
		getClickOnContactNameInput().sendKeys(ContactName);
		String originalWindow  = driver.getWindowHandle();
		getClickOnCampaignBtn().click();
		wdUtility.switchToNewWindow();
		// wait and "select " button
		
		new WebDriverWait(driver,Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(	getClickOnCampaignFromList())).click();
		wdUtility.switchToOriginalWindow(originalWindow);
		
		getClickOnCreateContactBtn().click();
	}
	

}
