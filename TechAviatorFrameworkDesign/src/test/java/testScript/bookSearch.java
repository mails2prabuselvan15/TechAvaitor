package testScript;

import java.util.HashMap;

import org.testng.annotations.Test;

import dataProvider.Data_Search;
import genericLib.BaseSetup;

public class bookSearch extends BaseSetup {
	
	@Test (dataProvider="ValidDP", dataProviderClass=dataProvider.Data_Search.class)
	public void InvalidSearch(HashMap<String, String> hmap) {
		System.out.println("Invalid search cases started to execute");
		
		System.out.println("The Script name is " +hmap.get("Scriptname"));
		
		System.out.println("The Script name is " +hmap.get("SearchText"));
		
		System.out.println("The Script name is " +hmap.get("ExpectedResult"));
		
		
	}
	
//	@Test (dataProvider="InvalidDP",dataProviderClass=Data_Search.class)
//	public void ValidSearch() {
//		System.out.println("Valid search cases started to execute");
//	}
	
	

}
