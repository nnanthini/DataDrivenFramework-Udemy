package utilities;

import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import base.BaseClass;

public class ExcelReader extends BaseClass {

	public String excelFilePath = null;
	private XSSFWorkbook workBook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row;
	private XSSFCell cell;

	public ExcelReader(String filePath) {
		excelFilePath = filePath;
		try {
			FileInputStream fis = new FileInputStream(excelFilePath);
			workBook = new XSSFWorkbook(fis);
			fis.close();
		} catch (Throwable t) {
			log.debug(t.getMessage());
		}

	}

	public Object[][] getData(String sheetName) {
		Object[][] data = null;
		try {
			sheet = workBook.getSheet(sheetName);

			if (sheet != null) {
				int rowCount, colCount;
				rowCount = sheet.getLastRowNum();
				colCount = sheet.getRow(rowCount).getLastCellNum();

				data = new Object[rowCount][colCount];

				for (int i = 1; i <= rowCount; i++) {
					row = sheet.getRow(i);
					for (int j = 0; j < colCount; j++) {
						cell = row.getCell(j);
						data[i - 1][j] = cell.getStringCellValue();
					}
				}
			}
		} catch (Throwable t) {
			log.debug(t.getMessage());
		}

		return data;
	}

}
