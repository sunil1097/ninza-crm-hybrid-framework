package com.ninza.crm.tests.contacts;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.ninza.crm.base.utility.BaseTest;
import com.ninza.crm.object.repository.ContactsPage;

public class DeleteContactTest extends BaseTest{
	ContactsPage cp;
	@Test(priority=3)
	void deleteContact(ITestContext context) {
		
		String oldName= (String) context.getAttribute("ContactName");
		String generatedContactId= (String) context.getAttribute("ContactId");
		cp.deleteContact(generatedContactId, oldName, generatedContactId);
		
	}

	
	
}
