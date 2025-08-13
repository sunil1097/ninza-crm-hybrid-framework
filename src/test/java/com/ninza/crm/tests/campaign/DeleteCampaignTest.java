package com.ninza.crm.tests.campaign;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.ninza.crm.base.utility.BaseTest;
import com.ninza.crm.object.repository.CampaignsPage;

public class DeleteCampaignTest extends BaseTest {
	CampaignsPage cp;
	@Test(priority=3)
	void testDeleteCampaign(ITestContext context) {
		String CampaignName= (String) context.getAttribute("campaignName");
		cp= new CampaignsPage(driver);
		cp.deleteCampaign(CampaignName);
		
		
		
	}

}
