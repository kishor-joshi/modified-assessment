package com.atmecs.helper;

import java.io.FileInputStream;



import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

/**
 * 
 * @author kishor.joshi
 *
 */
public class HelperClass {
	
	/**
	 * this method will read data from Excel sheet and send and returns as String array
	 * @param file
	 * @return String[][]
	 * @throws IOException
	 */
	public static String[][] getData(String file) throws IOException {
		FileInputStream fileInput = new FileInputStream(file);
		XSSFWorkbook book = new XSSFWorkbook(fileInput);
		org.apache.poi.ss.usermodel.Sheet sheet = book.getSheetAt(0);
		int row1 = sheet.getLastRowNum();
		row1 += 1;
		int col = sheet.getRow(0).getLastCellNum();
		String array[][] = new String[row1][col];
		int count = 0;
		for (Row row : sheet) {
		int count1 = 0;
		for (Cell cell : row) {
		String Data = cell.toString();
		array[count][count1] = Data;
		count1++;
		}
		count++;
		
		}
		return array;
		
		}


		@DataProvider(name="data")
		public  String[][] getdata() throws IOException {

		   return HelperClass.getData(".\\src\\test\\resources\\testdata\\dataread.xlsx");
		}
		
}
