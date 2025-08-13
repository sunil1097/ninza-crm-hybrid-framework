package com.ninza.crm.base.utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.ninza.crm.generic.utility.FileUtility;
import com.ninza.crm.generic.utility.WebDriverUtility;
import com.ninza.crm.object.repository.LoginPage;

public class BaseTest {
	public WebDriver driver =null;
	public static WebDriver sdriver =null;
	public LoginPage lp;
	public WebDriverUtility wdUtil;
	public FileUtility fUtil = new FileUtility();
	
	
	/**
	 * this method will launch the browser 
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	@BeforeClass
	public void browserLaunch(ITestContext context) throws IOException, InterruptedException {
		String Browser = fUtil.getDataFromPropFile("bro");
		if(Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if (Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		sdriver=driver;
		wdUtil = new WebDriverUtility(driver);
		lp = new LoginPage(driver);
		wdUtil.maxWindow();
		wdUtil.implicitWait();
		context.setAttribute("driver", driver);
		
		
	}
	/**
	 * this method fetch
	 * @throws IOException 
	 */
	@BeforeMethod
	public void login() throws IOException {
		String url = fUtil.getDataFromPropFile("url");
		String username = fUtil.getDataFromPropFile("un");
		String password = fUtil.getDataFromPropFile("pwd");
		driver.get(url);
		lp.login(username, password);	
	}
	@AfterMethod
	public void logOut() {
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
