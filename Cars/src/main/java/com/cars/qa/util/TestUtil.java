package com.cars.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cars.qa.base.TestBase;

public class TestUtil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	
	public void explicitWait(int time, By by) {
		WebDriverWait explicitDriver=new WebDriverWait(driver, time);
		explicitDriver.until(ExpectedConditions.presenceOfElementLocated(by));

	}
	
}
