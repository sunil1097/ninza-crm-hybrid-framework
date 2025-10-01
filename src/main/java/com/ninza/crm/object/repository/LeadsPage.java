package com.ninza.crm.object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ninza.crm.generic.utility.WebDriverUtility;
import com.ninza.crm.model.Lead;

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
	
	@FindBy(xpath="//input[@name='phone']")
	private WebElement phoneInput;
	
	// click on Campaign button to select the campaign by name or id 
	@FindBy(xpath="//div[@class='form-group']//button[@type='button']")
	private WebElement clickOnCampaignBtn;
		
		
	// low level Actions 
	public void clickAddContactButton() {
		addCreateLead.click();
	}
	public void enterTheLeadName(String leadName) {
		leadNameInput.sendKeys(leadName);
	}
	public void enterCompanyName(String companyName) {
		companyNameInput.sendKeys(companyName);
	}
	public void enterTheLeadSourceName(String leadSource) {
		leadSourceInput.sendKeys(leadSource);
	}
	public void enterTheIndustryName(String industry) {
		industryNameInput.sendKeys(industry);
	}
	public void enterTheLeadStatus(String leadStatus) {
		leadStatusInput.sendKeys(leadStatus);
	}
	public void enterThePhoneNo(String phoneNo) {
		phoneInput.sendKeys(phoneNo);
	}
	
	
	
	//Business flows
	public void createLead(Lead lead,String campaingNameFromExcel) {
		clickAddContactButton();
		enterTheLeadName(lead.getName());
		enterCompanyName(lead.getCompany());
		enterTheLeadSourceName(lead.getLeadSource());
		enterTheIndustryName(lead.getIndustry());
		enterTheLeadStatus(lead.getLeadStatus());
		enterThePhoneNo(lead.getPhone());
		clickOnCampaignBtn.click();
	}
	

}
