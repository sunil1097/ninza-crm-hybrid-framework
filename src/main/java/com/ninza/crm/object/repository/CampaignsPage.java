package com.ninza.crm.object.repository;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninza.crm.generic.utility.WebDriverUtility;

public class CampaignsPage extends BasePage{

	WebDriverUtility wdUtil;
	
	public CampaignsPage(WebDriver driver){
		super(driver);
		this.wdUtil= new WebDriverUtility(driver); // initialize webdriver utility
	}
	@FindBy(xpath="//span[normalize-space()='Create Campaign']")
	private WebElement clickCampaignPageBtn;

	@FindBy(name ="campaignName")
	private WebElement clickOnCampaignNameInput;

	
	@FindBy(name="campaignStatus")
	private WebElement clickOnCampaignStatusInput;
	
	@FindBy(name="targetSize")
	private WebElement clickOnTargetSizeInpInput;

	@FindBy(xpath ="//textarea[@name='description']")
	private WebElement descriptionInput;

	@FindBy(xpath="//button[@type='submit']")
	private WebElement clickCampaignSubmitBtn;

	@FindBy(xpath="//select[@class='form-control']")
	private WebElement campaignDropDown;

	@FindBy(xpath="//input[@class='form-control']")
	private WebElement searchByCampaignName;

	@FindBy(xpath="//tbody/tr[1]/td[7]/a[1]/i[1]")
	private WebElement editAction;
	
	@FindBy(xpath="//button[text()='Update Campaign']")
	private WebElement updateBtn;

	// locate delete action button 
	@FindBy(xpath="//tbody/tr[1]/td[7]/a[2]/i[1]")
	private WebElement deleteAction;

	// locate the delete modal 
	@FindBy(id="deleteProductModal")
	private WebElement deleteModal;
	
	//locate delete inside delete modal   and click
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement clickOnDelete;

	// waiting for modal pop up to appear 
	public void waitUntilModalCloses(WebDriver driver, WebDriverUtility util) {
		wdUtil.deletePopUpModal(driver, deleteModal);
	}

	


	// Business Action for create campaign 
	
	public void createCampaign(String CampaignName,String targetSize,String campaignStatus,String description) throws InterruptedException {
		clickCampaignPageBtn.click();
		clickOnCampaignNameInput.sendKeys(CampaignName);
		clickOnCampaignStatusInput.sendKeys(campaignStatus);
		clickOnTargetSizeInpInput.clear();
		clickOnTargetSizeInpInput.sendKeys(targetSize);
		descriptionInput.sendKeys(description);
		clickCampaignSubmitBtn.submit();
		wdUtil.waitToastNotification(driver);
	}
	// business Action for editing the campaign 
	public void editCampaign(String oldName,String newName) {
		campaignDropDown.click();
		wdUtil= new WebDriverUtility(driver);
		wdUtil.selectByValue(campaignDropDown, "campaignName");
		searchByCampaignName.sendKeys(oldName);
		editAction.click();
		clickOnCampaignStatusInput.clear();
		searchByCampaignName.sendKeys(newName);
		updateBtn.click();
		wdUtil.waitToastNotification(driver);
		
	}
	// business Action for delete the campaign
	public void deleteCampaign(String campaignName) {
		campaignDropDown.click();
		wdUtil= new WebDriverUtility(driver);
		wdUtil.selectByValue(campaignDropDown, "campaignName");
		searchByCampaignName.sendKeys(campaignName);
		deleteAction.click();
		clickOnDelete.click();
		waitUntilModalCloses(driver,wdUtil);
	}
	//verify the campaignname is available in the list 
	public boolean isCampaignPresent(String CampaignName ) {
		try {
			return driver.findElement(By.xpath("//td[text()='"+CampaignName+"']")).isDisplayed();
		}catch(NoSuchElementException e) {
			return false;
		}
	}

}
