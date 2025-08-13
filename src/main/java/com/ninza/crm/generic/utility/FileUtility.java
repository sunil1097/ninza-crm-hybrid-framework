package com.ninza.crm.generic.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class FileUtility {

	    
	/**
	 * this method will fetch  the value of given key in properties file 
	 * @throws IOException
	 * @param properties key 
	 * @author sunil
	 */
	public String getDataFromPropFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\dell\\Hybrid-FrameWork\\ninza-crm-automation\\src\\test\\resources\\commonData.properties");
		
		Properties  pObj = new Properties();
		pObj.load(fis);
		String VALUE = pObj.getProperty(key);
		return VALUE;
	}
	// for Campaign page 
	
	public static List<List<String>> readCampaignsSheetData() throws EncryptedDocumentException, IOException{
		
		List<List<String>> dataList = new ArrayList<>();
		//load the excel file 
		FileInputStream fis = new FileInputStream("C:\\Users\\dell\\Hybrid-FrameWork\\ninza-crm-automation\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Campaigns");
		int totalRows = sh.getLastRowNum();
		int totalCol = sh.getRow(0).getLastCellNum();
		DataFormatter formatter = new DataFormatter();
		
		for (int i=1;i<=totalRows;i++) {
			Row row =sh.getRow(i);
			List<String> rowData = new ArrayList<>();
			for(int j=0;j<totalCol;j++) {
				  String cellValue = formatter.formatCellValue(row.getCell(j)).trim();
	                rowData.add(cellValue);
			}
			dataList.add(rowData);
		}
		wb.close();
		fis.close();
		return dataList;
		
	}
	
	// data driver for contacts page 
	public static List<List<String>> readContactSheetData() throws EncryptedDocumentException, IOException{
		
		List<List<String>> dataList = new ArrayList<>();
		FileInputStream fis = new FileInputStream("C:\\\\Users\\\\dell\\\\Hybrid-FrameWork\\\\ninza-crm-automation\\\\src\\\\test\\\\resources\\\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh =wb.getSheet("Contacts");
		int totalRows =sh.getLastRowNum();
		int totalCols =sh.getRow(0).getLastCellNum();
		DataFormatter formatter = new DataFormatter();
		
		for (int i=1;i<=totalRows;i++) {
			Row row = sh.getRow(i);
			List<String> rowData= new ArrayList<>();
			for(int j=0;j<totalCols;j++) {
				String cellValue =formatter.formatCellValue(row.getCell(j)).trim();
				rowData.add(cellValue);
			}
			dataList.add(rowData);
		}
		wb.close();
		fis.close();
		return dataList;
		
	}

   

		
		
		
	}
