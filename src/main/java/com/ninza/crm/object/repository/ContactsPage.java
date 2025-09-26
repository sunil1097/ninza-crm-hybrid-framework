package com.ninza.crm.object.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ninza.crm.generic.utility.WebDriverUtility;

public class ContactsPage extends BasePage {

	 WebDriverUtility wdUtil;
	 private String generatedContactId; // store it here
	
	public ContactsPage(WebDriver driver) {
		super(driver);
	 // use the driver to search the elements on this page 
		this.wdUtil= new WebDriverUtility(driver); // initiliaze here so we dont need ini again and again each method	
	}
	
	// click create contact button
	@FindBy(xpath="//span[normalize-space()='Create Contact']")
	private WebElement clickOnCreateContactButton;

	
	// click on Organization input field 
	@FindBy(xpath="//input[@name='organizationName']")
	private WebElement clickOnOrganizationNameInput;

	//click on title input field 
	@FindBy(xpath="//input[@name='title']")
	private WebElement clickOnTitleInput;

	// click on Contact name input field
	@FindBy(xpath="//input[@name='contactName']")
	private WebElement clickOnContactNameInput;

	// click on Mobile input field 
	@FindBy(xpath="//input[@name='mobile']")
	private WebElement clickOnMobileInput;

	// click on Campaign button to select the campaign by name or id 
	@FindBy(xpath="//div[@class='form-group']//button[@type='button']")
	private WebElement clickOnCampaignBtn;

	//select a list from campaign list 
	
	@FindBy(xpath="//tbody/tr[1]/td[7]/button[1]")
	private WebElement clickOnCampaignFromList;

	
	//click on Create contact button 
	@FindBy(xpath="//button[@type='submit']")
	private WebElement clickOnCreateContactBtn;
	
	//navigate to contact 
	
	@FindBy(xpath ="//a[normalize-space()='Contacts']")
	private WebElement navigateToContact;
	// contactId ,better use By locator since its dynamic 
	By contactIdLocator = By.cssSelector("tbody tr:nth-child(1) td:nth-child(1)");
	
	// select contact dropdown
	@FindBy(xpath="//select[@class='form-control']")
	private WebElement contactDropDown;
	
	// type contactId in search box 
	@FindBy(xpath="//input[@placeholder='Search by Contact Id']")
	private WebElement searchByContactId;

	
	// click edit icon to edit 
	@FindBy(xpath="//i[@title='Edit']")
	private WebElement clickOnEditIcon;
	
	// inside edit Contact form , edit contact name
	@FindBy(xpath="//input[@name='contactName']")
	private WebElement clickOnContactNameEdit;
	// locate delete action button 
	@FindBy(xpath="//tbody/tr[1]/td[7]/a[2]/i[1]")
	private WebElement deleteAction;
	
	// locate the delete modal 
	@FindBy(id="deleteProductModal")
	private WebElement deleteModal;
	
	//locate delete inside delete modal   and click
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement clickOnDelete;
	// waiting for modal pop up to displayed
		public void waitUntilModalOpens() {
			wdUtil.waitForModalVisible(deleteModal,10);
		}
		// Wait until delete modal is closed
		public void waitUntilModalCloses() {
		    wdUtil.waitForModalInvisible(deleteModal, 10);
		}
	
	
	// Business Action  for Create Contact 
	public String createContact(String OrgName,String Title,String ContactName,String Mobile) {
		navigateToContact.click();
		
		clickOnCreateContactButton.click();
		clickOnOrganizationNameInput.sendKeys(OrgName);
		clickOnTitleInput.sendKeys(Title);
		clickOnMobileInput.sendKeys(Mobile);
		clickOnContactNameInput.sendKeys(ContactName);
		
		String originalWindow  = driver.getWindowHandle();
		clickOnCampaignBtn.click();
		wdUtil.switchToNewWindow();
		// wait and "select " button
		
		wdUtil.waitForElementClickable(clickOnCampaignFromList, 10).click();
		wdUtil.switchToOriginalWindow(originalWindow);
		
		clickOnCreateContactBtn.click();
	    // Wait for Contact ID to appear
		WebElement contactIdElement= wdUtil.waitForElementVisible(contactIdLocator, 10);
		generatedContactId=contactIdElement.getText().trim();
		return generatedContactId;
		
	

		
		
	}
	
	// Business Action for edit the Contact
	public void editContact(String contactId,String newContactName,String contactValue ) {
		navigateToContact.click();
		//select and search contact id 
		wdUtil.selectByValue(contactDropDown, contactId);
		searchByContactId.sendKeys(contactId);
		
		clickOnEditIcon.click();
		clickOnContactNameEdit.clear();
		clickOnContactNameEdit.sendKeys(newContactName);
		
		String originalWindow  = driver.getWindowHandle();
		clickOnCampaignBtn.click();
		wdUtil.switchToNewWindow();
		// wait and "select " button
		
		wdUtil.waitForElementClickable(clickOnCampaignFromList, 10).click();
		wdUtil.switchToOriginalWindow(originalWindow);
		
		clickOnCreateContactBtn.click();
		wdUtil.waitToastNotification(driver);
	}
	// Business Action For Delete the contact 
	public void deleteContact(String generatedContactId,String newContactName,String contactId) {
		navigateToContact.click();
		if(generatedContactId==null) {
			 throw new IllegalStateException("No contact ID stored. Create contact before editing.");
		}
		wdUtil.selectByValue(contactDropDown, contactId);
		searchByContactId.sendKeys(generatedContactId);
		deleteAction.click();
		waitUntilModalOpens();
		clickOnDelete.click();
		waitUntilModalCloses();
		wdUtil.waitToastNotification(driver);
	}

}
