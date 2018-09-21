package com.excel.utility;

import java.util.ArrayList;

public class TestUtil {

	
	//object of Generic class already created created 
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]> myData=new ArrayList<>();
		
		try {
			
			reader=new Xls_Reader("D:\\Selenium Practice\\DataDriven FrameworkTestNG\\src\\com\\testdata\\FalfEbayRegData.xlsx");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//Actual data is present from row no 2--r
		for(int rowNum=2; rowNum<=reader.getRowCount("regData");rowNum++) {
			
			String firstName=reader.getCellData("regData", "firstname", rowNum);
			
			String lastName=reader.getCellData("regData", "lastname", rowNum);
			
			String emailAddress=reader.getCellData("regData", "emailaddress", rowNum);
			
			String password=reader.getCellData("regData", "password", rowNum);
			
			
			Object ob[]= {firstName, lastName, emailAddress,password};
			
			myData.add(ob);
			
		}
		return myData;
	}
	
	
}
