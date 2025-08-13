package com.ninza.crm.object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement un;
	
	@FindBy(id="inputPassword")
	private WebElement pwd;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement signBtn;
	
	public WebElement getUn() {
		return un;
	}
	public WebElement getPwd() {
		return pwd;
	}
	public WebElement getSignBtn() {
		return signBtn;
		
	}
	//Business Utility
	
	public void login(String userName ,String passWord) {
		getUn().sendKeys(userName);
		getPwd().sendKeys(passWord);
		getSignBtn().click();
	}
	
	

}
