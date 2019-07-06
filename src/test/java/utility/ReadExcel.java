package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readExcelData(String sheetName) {
		String[][] data = null;
		File file = new File("./data/"+sheetName+".xlsx");
		try {
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);	
			
			// Read the sheet
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			// Get the last row and last column
			int lastRow = sheet.getLastRowNum();
			XSSFRow row = sheet.getRow(0);
			short lastCol = row.getLastCellNum();
			System.out.println("Last Row = "+lastRow+" Last Column = "+lastCol);
			data = new String[lastRow][lastCol];
			
			// Get data from sheet
			for(int i=1;i<=lastRow;i++) {
				XSSFRow row_i = sheet.getRow(i);
				for(int j=0;j<lastCol;j++) {
					XSSFCell cell = row_i.getCell(j);
					String value = cell.getStringCellValue();
					data[i-1][j] = value;
				}
			}
			System.out.println("Data is "+Arrays.deepToString(data));
			workbook.close();
		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
		
		
	}
	
	public static void main(String[] args) {
		
		readExcelData("TestData");
	}

}
