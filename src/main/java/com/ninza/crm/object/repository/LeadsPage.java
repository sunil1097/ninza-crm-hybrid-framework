package com.ninza.crm.object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ninza.crm.generic.utility.WebDriverUtility;

public class LeadsPage extends BasePage{
	WebDriverUtility wdUtil;
	
	public LeadsPage(WebDriver driver) {
		super(driver);
		this.wdUtil=new WebDriverUtility(driver);
		
	}
	// locators
	
	@FindBy(xpath="//span[normalize-space()='Create Lead']")
	private WebElement addCreateLead;
	
	@FindBy(xpath="//input[@name='name']")
	private WebElement leadNameInput;
	
	@FindBy(xpath="//input[@name='company']")
	private WebElement companyNameInput;
	
	@FindBy(xpath="//input[@name='leadSource']")
	private WebElement leadSourceInput;
	
	@FindBy(xpath="//input[@name='industry']")
	private WebElement industryNameInput;
	
	@FindBy(xpath="//input[@name='leadStatus']")
	private WebElement leadStatusInput;
	
	// low level Actions 
	public void clickAddContactButton() {
		addCreateLead.click();
	}
	public void enterTheLeadName() {
		leadNameInput.sendKeys(null);
	}
	public void enterCompanyName() {
		companyNameInput.sendKeys(null);
	}
	public void enterTheLeadSourceName() {
		leadSourceInput.sendKeys(null);
	}
	public void enterTheIndustryName() {
		industryNameInput.sendKeys(null);
	}
	public void enterTheLeadStatus() {
		leadStatusInput.sendKeys(null);
	}
	
	//Business flows
	public void createLead() {
		
	}
	

}
