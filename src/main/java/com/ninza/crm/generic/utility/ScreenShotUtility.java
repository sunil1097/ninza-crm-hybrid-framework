package com.ninza.crm.generic.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.ninza.crm.base.utility.BaseTest;

public class ScreenShotUtility {
	public static String takeScreenShot(WebDriver driver, String testName) {
		
		/** takes a screenshot on failure 
		 * @author sunil
		 */
		String timestamp= new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		
		// building screenshot path
		String screenshotDir =System.getProperty("user.dir")+ "/errorShots";
		String screenshotName= testName + "_" + timestamp + ".png";
		String fullPath = screenshotDir + screenshotName;
		
		TakesScreenshot tks =(TakesScreenshot) BaseTest.sdriver;
		File src = tks.getScreenshotAs(OutputType.FILE);
		File dest = new File(fullPath);
		try {
		FileHandler.copy(src, dest);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return fullPath;
	}

}
