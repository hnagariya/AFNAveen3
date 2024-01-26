package com.naveenautomationlabs.AFramework.utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.naveenautomationlabs.AFramework.base.TestBase;

public class ExcelUtils extends TestBase {
	  private static FileInputStream fi;
	   private static XSSFWorkbook wb;
	   private static XSSFSheet ws;
	   private static XSSFRow rw;
	   private static XSSFCell cell;
	   
	   public static int getRowCount(String file, String sheet) throws Exception {
		   int rowCount;
		   fi=new FileInputStream(file);
		   wb= new XSSFWorkbook(fi);
		   ws=wb.getSheet(sheet);
		   rowCount=ws.getLastRowNum();
		   fi.close();
		   return rowCount;
	   }
	   public static int getColumnCount(String file,String sheet,int rowCount) throws Exception {
		   int columnCount;
		   fi=new FileInputStream(file);
		   wb= new XSSFWorkbook(fi);
		   ws=wb.getSheet(sheet);
		   rw=ws.getRow(rowCount);
		   columnCount=rw.getLastCellNum();
		   return columnCount;
	   }
	   public static String getCellData(String file,String sheet,int rowCount,int columnCount) throws Exception {
		   String data;
		   fi=new FileInputStream(file);
		   wb= new XSSFWorkbook(fi);
		   ws=wb.getSheet(sheet);
		   rw=ws.getRow(rowCount);
		   cell=rw.getCell(columnCount);
		   data=cell.getStringCellValue();
		   return data;
	   }
}
