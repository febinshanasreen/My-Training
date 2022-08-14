package com.obscura.ExcelRead;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelReadingLoop {
	
	static XSSFSheet sheet;
	static Row row;
	public ExcelReadingLoop() throws IOException{
		
		File newfile=new File("C:\\Users\\sanoop\\Desktop\\PRACTICES\\testdata.xlsx");
		FileInputStream file=new FileInputStream(newfile);
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet("Sheet1");
		
	}
	
	public String readDataFromExcel(int i,int j) {
		row=sheet.getRow(i);
		Cell cell=row.getCell(j);
		CellType type=cell.getCellType();
		switch(type)
		{
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
			
		case STRING:
			return cell.getStringCellValue();
		}
		
		return null;
		}
	
	public static int getRowSize() {
		return sheet.getLastRowNum()+1;
	}
	
	/*public static int getCellSize() {
		return row.getLastCellNum()+1;
	}*/
	

	public static void main(String[] args) throws Exception {


		ExcelReadingLoop obj=new ExcelReadingLoop();
		
	for(int i=0;i<getRowSize();i++) {
		for(int j=0;j<2;j++) {
			
			String s=obj.readDataFromExcel(i, j);
			System.out.println(s);
		}
	}
		
		
		
		
	}

}
