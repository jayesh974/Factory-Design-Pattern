package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import factory.BrowserType;
import factory.DriverFactory;
import factory.DriverFactoryWithSupplierImpl;

public class FactoryMethodDesignPattern {
	
	
	@DataProvider
	public Object[][] getData(){
		
		return new String[][] {
			{"chrome"}
		};
	}
	
/*	
	@Test(dataProvider = "getData")
	public void factoryMethodTest(String browser) {
		
		WebDriver driver = DriverFactory.getDriver(browser);
		driver.get("https://google.co.in");
		
	}	
*/
	
	@Test(dataProvider = "getData")
	public void factoryMethodTestWithSupplierImp(String browser) {
		
		WebDriver driver = DriverFactoryWithSupplierImpl.getDriver(BrowserType.CHROME);
		driver.get("https://google.co.in");
	}

	

}
