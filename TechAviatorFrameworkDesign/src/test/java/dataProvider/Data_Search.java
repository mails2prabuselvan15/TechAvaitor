package dataProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import excel.ExcelRW;

public class Data_Search {
	
	

	
	
	@DataProvider (name="ValidDP")		
	public Iterator<Object[]> validDataProvider() throws IOException  {
		Iterator<Object[]> searchdataprovider = Searchdataprovider("validSearch");
		return searchdataprovider;		
	}
	
	@DataProvider (name="InvalidDP")
	
	public Iterator<Object[]> InvalidDataProvider() throws IOException  {
		Iterator<Object[]> searchdataprovider = Searchdataprovider("invalidSearch");
		return searchdataprovider;		
	}
	
		
	
	
	
	
	
	
	
	
	@DataProvider(name="CommonDP")	
	public Iterator<Object[]> Searchdataprovider(String scriptname) throws IOException {
		 ExcelRW XL= new ExcelRW("C:\\Selenium\\TechAviatorFrameworkDesign\\src\\test\\resources\\dataprovider.xls");
		 HSSFSheet  setSheet = XL.SetSheet("Sheet1");
		
//		To get the last row num in the sheet
		int getrownum = XL.getrownum(setSheet);
//		To get the last column num in the sheet
		int getcolnum = XL.getcolnum(setSheet);		
		
//		Creating the list of type Object
		List<Object[]> ls= new ArrayList<Object[]>();
		for (int i=1; i<=getrownum; i++) {	
			
			System.out.println("Total number of rows " +getrownum);
			
//			Creating the hashmap of string type
			Map<String, String> hmap= new HashMap<String, String>();
			
//			Creating the single dimensional object array
			Object[] objArray= new Object[1];
			for (int j=0; j< getcolnum; j++) {
				
				System.out.println("Total number of columns " +getcolnum);
				
				String exeflag = XL.Readvalue(i, j, setSheet);
				String Scriptname = XL.Readvalue(i, j, setSheet);
				if (exeflag.equals("y") & Scriptname.equals(scriptname) ) {
					
				String colname = XL.Readvalue(0, j, setSheet);
//				To get the each cell value
				String cellvalue = XL.Readvalue(i, j, setSheet);
				hmap.put(colname, cellvalue);
			}
		}	
		objArray[0]=hmap;
		ls.add(objArray);
	}
		
	return ls.iterator();
		
	}
	

}
