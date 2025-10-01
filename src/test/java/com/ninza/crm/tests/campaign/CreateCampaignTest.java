package com.ninza.crm.tests.campaign;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.ninza.crm.base.utility.BaseTest;
import com.ninza.crm.generic.utility.FileUtility;
import com.ninza.crm.generic.utility.XlUtility;
import com.ninza.crm.object.repository.CampaignsPage;

public class CreateCampaignTest extends BaseTest {
	CampaignsPage cp;
	
	@Test(priority=1)
	public void testCreateCampaign(ITestContext context) throws EncryptedDocumentException, IOException, InterruptedException {
		Faker faker;
		//getting data from excel 
		List<List<String>> data = FileUtility.readCampaignsSheetData();
		cp= new CampaignsPage(driver);
		List<String> row =data.get(0);
		
		faker = new Faker();
			String  campaignName = faker.name().fullName();
			String targetSize = row.get(1);
			String campaignStatus= row.get(2);
			String description = row.get(3);
			
			cp.createCampaign(campaignName, targetSize, campaignStatus, description);
			
			String path = "C:\\Users\\dell\\Hybrid-FrameWork\\ninza-crm-automation\\src\\test\\resources\\TestData.xlsx";
			XlUtility xutil= new XlUtility(path);
			xutil.setCellData("CampaignData", 1, 0, campaignName);
		
			Assert.assertTrue(cp.isCampaignPresent(campaignName),"campaign creation failed:"+campaignName);
	
		context.setAttribute("campaignName", campaignName);
		
		}
		
		
	}

