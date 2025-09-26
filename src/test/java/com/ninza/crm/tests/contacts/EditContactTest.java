package com.ninza.crm.tests.contacts;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.ninza.crm.base.utility.BaseTest;
import com.ninza.crm.object.repository.ContactsPage;
import com.ninza.crm.object.repository.HomePage;

public class EditContactTest extends BaseTest {
	
	ContactsPage cp;
	HomePage hp;
	@Test(priority=2)
	
	public void testEditContact(ITestContext context) {
		
		
		String oldName= (String) context.getAttribute("ContactName");
		String generatedContactId= (String) context.getAttribute("ContactId");
		String updatedName = oldName+"updated";
		cp= new ContactsPage(driver);
		String campaignValue = "contactId"; // actual value of campaign option
		cp.editContact(generatedContactId, updatedName, campaignValue);
		
		context.setAttribute("contactname", updatedName);
		context.setAttribute("contactId", generatedContactId);
		System.out.println("Editing contact : " + updatedName);
		
	}

}
