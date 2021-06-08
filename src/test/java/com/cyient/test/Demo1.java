package com.cyient.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo1 {

	public static void main(String[] args) throws IOException {
		FileInputStream file= new FileInputStream("src/test/resources/testdata/OpenEMRData.xlsx");
		XSSFWorkbook book=new XSSFWorkbook (file);
		XSSFSheet sheet=book.getSheet("validCredentialTest");
		XSSFRow row=sheet.getRow(0);
		XSSFCell  cell=row.getCell(0);
		String cellValue= cell.getStringCellValue();
		System.out.println(cellValue);
	}

}
