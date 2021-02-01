package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseClass;
import dataprovider.DataProviderClass;

public class SearchFieldTest extends BaseClass {

	@Test(dataProvider = "dataprovider", dataProviderClass = DataProviderClass.class)
	public void testSearchField(String value1, String value2) throws InterruptedException {
		
		
		driver.findElement(By.cssSelector(pathProperties.getProperty("searchBtn"))).sendKeys(value1);
		Thread.sleep(4000);

	}
}
