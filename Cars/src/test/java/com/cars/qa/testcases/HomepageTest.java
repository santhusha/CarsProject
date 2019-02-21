package com.cars.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cars.qa.base.TestBase;
import com.cars.qa.pages.HomePage;
import com.cars.qa.pages.SearchResultsPage;

public class HomepageTest extends TestBase {
	HomePage homePage;
	SearchResultsPage searchResultsPage;
	public HomepageTest() {
		
	}
	@BeforeMethod
	public void setup() {
		initializeBrowser();
		homePage=new HomePage();
		}
	@Test
	public void homePageTitleTest() {
		log.info("In homePageTitleTest");
		String title=homePage.validateHomePageTitle();
		Assert.assertEquals(title, "New Cars, Used Cars, Car Reviews and News | Cars.com");
	}
	@Test
	public void searchTest() {
		log.info("In searchTest ..."); 
		homePage.clickOnSearchByBodyStyleLabel();
		homePage.selectAnOptionFromAllBodyStylesDropdown("SUV");
		searchResultsPage=homePage.search();
	}
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
}
