package com.ninza.crm.tests.leads;

import java.io.IOException;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.ninza.crm.base.utility.BaseTest;
import com.ninza.crm.generic.utility.XlUtility;
import com.ninza.crm.model.Lead;
import com.ninza.crm.object.repository.HomePage;
import com.ninza.crm.object.repository.LeadsPage;

public class CreateLeadTest extends BaseTest {
	HomePage hp;
	Faker faker;
	LeadsPage lp;
	
	@Test(priority=1,dataProvider="leadData",dataProviderClass=com.ninza.crm.dataProvider.LeadsDataProvider.class)
	public void createLeadTest(Lead lead) throws IOException {
		
		hp.navigateToLeads();
		 Faker faker = new Faker();
	     lead.setName(faker.name().fullName());
		
		// get Campaing Name for Creating A Lead
		String path ="C:\\Users\\dell\\Hybrid-FrameWork\\ninza-crm-automation\\src\\test\\resources\\TestData.xlsx";
		
		XlUtility xutil = new XlUtility(path);
		
		String campaignName =xutil.getCellData("CampaignData", 1, 0);
		lp.createLead(lead,campaignName);
		
		
	}

}
