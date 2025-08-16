package com.ninza.crm.tests.contacts;

import org.testng.ITestContext;

import com.ninza.crm.base.utility.BaseTest;
import com.ninza.crm.object.repository.ContactsPage;
import com.ninza.crm.object.repository.HomePage;

public class EditContactTest extends BaseTest {
	
	ContactsPage cp;
	HomePage hp;
	public void testEditContact(ITestContext context) {
		
		String oldName= (String) context.getAttribute("ContactName");
		String updatedName = oldName+"updated";
		cp= new ContactsPage(driver);
		
		System.out.println("Editing contact : " + updatedName);
		
	}

}
