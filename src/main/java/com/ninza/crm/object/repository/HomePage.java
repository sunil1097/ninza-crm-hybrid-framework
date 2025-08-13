package com.ninza.crm.object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	// navigate to Contact page 
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement navToContact;
	public WebElement getNavToContactPage() {
		return navToContact;
	}
	
	public void navToContact() {
		getNavToContactPage().click();
	}
	
	

}
