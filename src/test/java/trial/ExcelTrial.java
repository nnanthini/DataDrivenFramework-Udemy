package trial;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTrial {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		String path = "C:\\Users\\ezhil\\Desktop\\FrontEndNanodegree\\Udemy - Selenium\\Udemy - Selenium\\Eclipse Workspace\\src\\test\\resources\\excelsheet\\testdata.xlsx";
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workBook.getSheet("testSearchField");
		
		int rowCount = sheet.getLastRowNum();
		System.out.println("Row Count " +rowCount);
		XSSFRow row = sheet.getRow(rowCount-1);
		
		int colCount = row.getLastCellNum();
		System.out.println("Column count "+colCount);
		XSSFCell cell=null;
		
		Object[][] data = new Object[rowCount][colCount];
		for (int i=1;i<=rowCount;i++) {
			row = sheet.getRow(i);
			for(int j=0;j<colCount;j++) {
				cell=row.getCell(j);
				data[i-1][j] = cell.getStringCellValue();
				System.out.print(data[i-1][j]);
				System.out.print("\t");
				
			}
			System.out.println();
		}

	}

}
