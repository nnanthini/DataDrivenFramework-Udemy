package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

public class InitialPageLoadTest extends BaseClass{
	
	@Test
	public void checkTitle() {
		log.info("Executing checkTitle() test");
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Google";
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch");
		
	}

}
