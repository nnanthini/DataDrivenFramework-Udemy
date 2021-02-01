package dataprovider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import utilities.ExcelReader;

public class DataProviderClass {

	@DataProvider(name="dataprovider")
	public Object[][] dataProvider(Method m){
		
		String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\excelsheet\\testdata.xlsx";
		ExcelReader excel = new ExcelReader(filePath);	
		
		
		Object[][] data = excel.getData(m.getName());
		return data;
		
	}
}
