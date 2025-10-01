package com.ninza.crm.dataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.github.javafaker.Faker;
import com.ninza.crm.generic.utility.XlUtility;
import com.ninza.crm.model.Lead;

public class LeadsDataProvider {

    @DataProvider(name = "leadData")
    public Object[][] getLeadData() throws IOException {
        String path = "C:\\Users\\dell\\Hybrid-FrameWork\\ninza-crm-automation\\src\\test\\resources\\TestData.xlsx";
        XlUtility xutil = new XlUtility(path);

        int totalRows = xutil.getRowCount("Leads");
        int totalCols = xutil.getCellCount("Leads", 1);

        Object[][] data = new Object[totalRows][1]; // Single Lead object per row
        Faker faker = new Faker();

        for (int i = 1; i <= totalRows; i++) {
            // Generate dynamic Lead Name
            String leadName = faker.name().fullName();

            // Read other fields from Excel
            String company = xutil.getCellData("Leads", i, 0);
            String campaign = xutil.getCellData("Leads", i, 1);
            String leadSource = xutil.getCellData("Leads", i, 2);
            String industry = xutil.getCellData("Leads", i, 3);
            String leadStatus = xutil.getCellData("Leads", i, 4);
            String phone = xutil.getCellData("Leads", i, 5);

            // Create Lead object
            Lead lead = new Lead(leadName, company, campaign, leadSource, industry, leadStatus, phone);

            data[i - 1][0] = lead;
        }

        return data;
    }
}
