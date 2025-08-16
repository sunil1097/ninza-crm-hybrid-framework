package com.ninza.crm.generic.utility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * This class contains reusable WebDriver utility methods such as window
 * management, waits, dropdown selections, mouse and keyboard interactions. It
 * also includes additional utilities such as alerts, scrolling, screenshot, JS
 * execution, drag-drop, sliders, and more.
 * @version 1.0
 * @author Sunil Samal
 */
public class WebDriverUtility {
	WebDriver driver;
	
	public WebDriverUtility(WebDriver driver) {
		this.driver=driver;
		
	}
	public void maxWindow() {
		driver.manage().window().maximize();
	}
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void hover(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void selectByValue(WebElement dropDown, String selectByValue) {
		Select sel = new Select(dropDown);
		sel.selectByValue(selectByValue);	
	}
	// delete pop modal 
	public void deletePopUpModal(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	//wait for toast notification to disappear 
	public void waitToastNotification(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)) ;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast-container")));
	}
	
	//swtich to new window 
	public void switchToNewWindow() {
		
		// store original window 
		String originalWindow  = driver.getWindowHandle();
	
		// wait for another window open to be 
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		// switch back to new window 
		
		Set<String>allWindow =driver.getWindowHandles();
		for (String window : allWindow)
		{
			if(!window.equals(originalWindow )) {
				driver.switchTo().window(window);
				break;
			}
		}
	}
	//swtich to main window 
	
	public void switchToOriginalWindow(String originalWindow) {
		driver.switchTo().window(originalWindow);
	}
	// wait for element to be clickable 
	public WebElement waitForElementClickable(WebElement element,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	// wait  for element to be visible // dynamic used for By locator 
	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	// optional we want to use findBy for dynamic elements 
	 // Overload: visible using WebElement
    public WebElement waitForElementVisible(WebElement element, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
	
	

}
