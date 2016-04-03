package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ExcelRW {
	
	File file;
	FileInputStream fis;
	HSSFWorkbook wb;
	
	public ExcelRW(String filepath) throws IOException {
		
	file=new File(filepath);
	wb= new HSSFWorkbook(fis);
	try {
		fis= new FileInputStream(file);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		System.out.println("Unable to load the file");
		}
	}
	public HSSFSheet SetSheet(String sheet) {
	  HSSFSheet setsheet = wb.getSheet(sheet);
	  return setsheet;

	}
	
	public int getrownum (HSSFSheet setsheet) {
		int lastRowNum = setsheet.getLastRowNum();
		return lastRowNum;
	}
	public int getcolnum(HSSFSheet setsheet) {
		int lastCellNum = setsheet.getRow(0).getLastCellNum();		
		 return lastCellNum;		
	}
	
	  public String Readvalue(int  row, int col,HSSFSheet setsheet) {
		  String readcellvalue="";
		  HSSFRow rowval = setsheet.getRow(row);
		  HSSFCell cellval = rowval.getCell(col);
		  if (cellval.getCellType()== cellval.CELL_TYPE_STRING) {
			  readcellvalue = cellval.getStringCellValue();
			
		} else{
			double cellvalue = cellval.getNumericCellValue();
			 readcellvalue = String.valueOf(cellvalue);
		}
		    
		  return readcellvalue;	  
	  }
  
 
  public void Writevalue(int  row, int col,HSSFSheet setsheet,String text) {	  
	  HSSFRow rowval = setsheet.getRow(row);
	  
	  if (rowval==null) {
		  HSSFRow createRow = setsheet.createRow(row);
		  HSSFCell cell = createRow.getCell(col);
		  	if (cell==null) {
		  		HSSFCell createCell = createRow.createCell(col);
		  		createCell.setCellValue(text);				
			}
	  	}
  	}
 }
