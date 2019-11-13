package com.jstech.calculatortestatsk;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	public ExcelUtil() {
		try {
			workbook = new XSSFWorkbook("C:\\Users\\Jaspreetsingh_Tuli\\Desktop\\Refs\\calculatortestatsk\\files\\sumDataLong.xlsx");
			sheet = workbook.getSheet("Sheet1");
		}
		catch(IOException e) {
			
		}
	}
		public Object[][] sumData()
			{
				
				int rowCount = sheet.getPhysicalNumberOfRows();
				int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
				Object[][] object = new Object[rowCount][colCount];
				for(int row =0;row<rowCount ;row++)
				{
					for(int col =0; col< colCount ;col++)
					{
						
						object[row][col] = sheet.getRow(row).getCell(col).getNumericCellValue();
					}
				}
				return object;
			} 
		 

}
