package com.fb.qa.util;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.fb.qa.base.TestBase;

public class TestUtil extends TestBase {
	 public static long PAGE_LOAD_TIMEOUT=40;
	 public static long IMPLICIT_WAIT=40;
	 
	 public static String TEST_SHEET_PATH="C:\\Users\\sunil\\Documents\\priya\\HybridFramework\\src\\main\\java\\com\\fb\\qa\\testdata\\dataDriven.xlsx";
	 static Workbook book;
	 static Sheet sheet;

	/*
	 * public void switchToFrame() { driver.switchTo().frame(nameOrId); }
	 */
	 public static Object[][] getTestData(String sheetName){
		 FileInputStream file=null;
		 try {
			 file=new FileInputStream(TEST_SHEET_PATH);
		 }catch (Exception e) {
			// TODO: handle exception
		}
		 
		 try {
			 book=WorkbookFactory.create(file);			 
		 }catch (Exception e) {
			// TODO: handle exception
		}
		 
		 sheet=book.getSheet(sheetName);
		 Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 for(int i=0;i<sheet.getLastRowNum();i++)
		 {
			 System.out.println(sheet.getLastRowNum());
			 for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) 
			 {
				 data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			 }
		 }
		 return data;
	 }
	 
	

}
