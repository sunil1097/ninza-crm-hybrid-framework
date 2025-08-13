package com.ninza.crm.object.repository;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninza.crm.generic.utility.WebDriverUtility;

public class CampaignsPage {
	WebDriver driver;
	WebDriverUtility wdUtil;
	
	public CampaignsPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wdUtil= new WebDriverUtility(driver); // initialize webdriver utility
	}
	@FindBy(xpath="//span[normalize-space()='Create Campaign']")
	private WebElement clickCampaignPageBtn;
	public WebElement getClickCampaignPageBtn() {
		return clickCampaignPageBtn;
	}
	@FindBy(name ="campaignName")
	private WebElement clickOnCampaignNameInput;
	
	public WebElement getClickOnCampaignInput(){
		return clickOnCampaignNameInput;
	}
	
	@FindBy(name="campaignStatus")
	private WebElement clickOnCampaignStatusInput;
	public WebElement getClickOnCampaignStatusInput() {
		return clickOnCampaignStatusInput;
	}
	
	@FindBy(name="targetSize")
	private WebElement clickOnTargetSizeInpInput;
	
	public WebElement getClickOnTargetSizeInput(){
		return clickOnTargetSizeInpInput;
	}
	@FindBy(xpath ="//textarea[@name='description']")
	private WebElement descriptionInput;
	public WebElement getClickOnDescriptonInput() {
		return descriptionInput;
	}
	@FindBy(xpath="//button[@type='submit']")
	private WebElement clickCampaignSubmitBtn;
	public WebElement getClickCampaignSubmitBtn() {
		return clickCampaignSubmitBtn;
	}
	@FindBy(xpath="//select[@class='form-control']")
	private WebElement campaignDropDown;
	public WebElement getCampaignDropDown() {
		return campaignDropDown;
	}
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement searchByCampaignName;
	public WebElement getSearchByCampaignName() {
		return searchByCampaignName;
	}
	@FindBy(xpath="//tbody/tr[1]/td[7]/a[1]/i[1]")
	private WebElement editAction;
	public WebElement getClickOnEditAction() {
		return editAction;
	}
	@FindBy(xpath="//button[text()='Update Campaign']")
	private WebElement updateBtn;
	public WebElement getClickOnUpdateBtn() {
		return updateBtn;
	}
	// locate delete action button 
	@FindBy(xpath="//tbody/tr[1]/td[7]/a[2]/i[1]")
	private WebElement deleteAction;
	public WebElement getClickOnDeleteBtn() {
		return deleteAction;
	}
	// locate the delete modal 
	@FindBy(id="deleteProductModal")
	private WebElement deleteModal;
	public WebElement getDeleteModal() {
		return deleteModal;
	}
	//locate delete inside delete modal   and click
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement clickOnDelete;
	public WebElement getClickOnDelete() {
		return clickOnDelete;
	}
	// waiting for modal pop up to appear 
	public void waitUntilModalCloses(WebDriver driver, WebDriverUtility util) {
		wdUtil.deletePopUpModal(driver, deleteModal);
	}

	


	// Business Utility for create campaign 
	
	public void createCampaign(String CampaignName,String targetSize,String campaignStatus,String description) throws InterruptedException {
		getClickCampaignPageBtn().click();
		getClickOnCampaignInput().sendKeys(CampaignName);
		getClickOnCampaignStatusInput().sendKeys(campaignStatus);
		getClickOnTargetSizeInput().clear();
		getClickOnTargetSizeInput().sendKeys(targetSize);
		getClickOnDescriptonInput().sendKeys(description);
		getClickCampaignSubmitBtn().submit();
		wdUtil.waitToastNotification(driver);
	}
	// business utility for editing the campaign 
	public void editCampaign(String oldName,String newName) {
		getCampaignDropDown().click();
		wdUtil= new WebDriverUtility(driver);
		wdUtil.selectByValue(campaignDropDown, "campaignName");
		getSearchByCampaignName().sendKeys(oldName);
		getClickOnEditAction().click();
		getClickOnCampaignInput().clear();
		getClickOnCampaignInput().sendKeys(newName);
		getClickOnUpdateBtn().click();
		wdUtil.waitToastNotification(driver);
		
	}
	// business utility for delete the campaign
	public void deleteCampaign(String campaignName) {
		getCampaignDropDown().click();
		wdUtil= new WebDriverUtility(driver);
		wdUtil.selectByValue(campaignDropDown, "campaignName");
		getSearchByCampaignName().sendKeys(campaignName);
		getClickOnDeleteBtn().click();
		getClickOnDelete().click();
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
