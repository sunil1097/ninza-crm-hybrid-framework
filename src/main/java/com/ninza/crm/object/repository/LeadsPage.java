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
	@FindBy(xpath="//span[normalize-space()='Create Lead']")
	private WebElement plusIconCreateLead;
	
	

}
