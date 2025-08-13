package com.ninza.crm.tests.contacts;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.ninza.crm.base.utility.BaseTest;
import com.ninza.crm.generic.utility.FileUtility;
import com.ninza.crm.object.repository.ContactsPage;
import com.ninza.crm.object.repository.HomePage;

public class CreateContactTest extends BaseTest {
	
	ContactsPage cp;
	HomePage hp;
	@Test(priority=1)
	public void testCreateContact(ITestContext context) throws EncryptedDocumentException, IOException {
		
		hp= new HomePage(driver);
		hp.navToContact();
		List<List<String>> data = FileUtility.readContactSheetData();
		cp= new ContactsPage(driver);
		List<String> row = data.get(0);
		String OrgName= row.get(2);
		String Title = row.get(3);
		String ContactName= row.get(0)+ "sunil";
		String Mobile = row.get(1);
		cp.createContact(OrgName, Title, ContactName, Mobile);
		
		context.setAttribute("ContactName", ContactName);
		
		
	}

}
