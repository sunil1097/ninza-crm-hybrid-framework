package com.ninza.crm.tests.campaign;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.ninza.crm.base.utility.BaseTest;
import com.ninza.crm.object.repository.CampaignsPage;

public class EditCampaignTest extends BaseTest {
	
	CampaignsPage cp;
	@Test(priority=2)
	public void testEditCamppaign(ITestContext context) throws InterruptedException{
		
		String oldName= (String) context.getAttribute("campaignName");
		String updatedName = oldName+"updated";
		cp= new CampaignsPage(driver);
		cp.editCampaign(oldName, updatedName);
		context.setAttribute("campaignName",updatedName);	
		System.out.println("Editing campaign: " + updatedName);

		
	}
	{
		
		
	}
}
