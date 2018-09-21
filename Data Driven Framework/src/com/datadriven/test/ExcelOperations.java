package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Xls_Reader reader=new Xls_Reader("D:\\Selenium Practice\\Data Driven Framework\\src\\com\\testdata\\FalfEbayRegData.xlsx");
		
	
		//Add sheet
		//reader.addSheet("HomePage");
		
		//Always write below if code while creating any sheet so it will check for existance first and then add sheet
		if(!reader.isSheetExist("LoginPage")) {
			reader.addSheet("LoginPage");
			
		}
		
		// It gives column count in sheet
		int colCount=reader.getColumnCount("regData");
		System.out.println(colCount);
		int rowNo=reader.getCellRowNum("regData", "firstname", "Datta");
		
		System.out.println(rowNo);
		System.out.println("Operation done..");
		
	}

}
