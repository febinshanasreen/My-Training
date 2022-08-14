package com.obscura.ExcelRead;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Excel_Read_SingleCell {
	
	XSSFSheet sheet;
	public Excel_Read_SingleCell() throws IOException{
		
		File newfile=new File("C:\\Users\\sanoop\\Desktop\\PRACTICES\\testdata.xlsx");
		FileInputStream file=new FileInputStream(newfile);
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet("Sheet1");
		
	}
	
	public String readDataFromExcel(int i,int j) {
		Row row=sheet.getRow(i);
		Cell cell=row.getCell(j);
		return cell.getStringCellValue();
	}
	
	/*public int readDataFromExcel(int i,int j) {
		Row row=sheet.getRow(i);
		Cell cell=row.getCell(j);
		return cell.getStringCellValue();
	}*/
	
	

	public static void main(String[] args) throws Exception {


		 Excel_Read_SingleCell obj=new Excel_Read_SingleCell();
		
		String s=obj.readDataFromExcel(0,1);
		System.out.println(s);
		
		
		
		
		
	}

}
