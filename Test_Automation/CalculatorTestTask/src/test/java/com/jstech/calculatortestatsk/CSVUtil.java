package com.jstech.calculatortestatsk;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;

public class CSVUtil {

	public Object[][] subtractionUsingDataFromCSV(){
		CSVReader csvReader;
		int rows;
		int cols;
		Object[][] object = null;
		List<String[]> data;
		
		try {
			csvReader = new CSVReader(new FileReader("C:\\Users\\Jaspreetsingh_Tuli\\Desktop\\Refs\\calculatortestatsk\\files\\subData.csv"));
			
			data =csvReader.readAll();
			//System.out.println(data.size());
			rows = data.size();
			cols = data.get(0).length;
			System.out.println(rows+" --  "+cols);
			object = new Object[rows][cols];
			
			for(int rowCount = 0; rowCount < rows; rowCount++) {
				for(int colCount = 0; colCount< cols; colCount++) {
					object[rowCount][colCount] = Long.parseLong(data.get(rowCount)[colCount]);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return object;
		
	}
}
