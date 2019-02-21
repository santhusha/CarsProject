package com.cars.qa.testcases;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cars.qa.base.TestBase;
import com.cars.qa.pages.HomePage;
import com.cars.qa.pages.SearchResultsPage;

public class SearchResultsPageTest extends TestBase{
	SearchResultsPage searchResults;
	HomePage homePage;
	public SearchResultsPageTest() {
		
	}
	@BeforeMethod
	public void setup() {
		initializeBrowser();
		homePage=new HomePage();
		searchResults=new SearchResultsPage();
		}
	@Test
	public void SearchResultsPageTitleTest() {
		String title=homePage.search().validateSearchResultsPageTitle();
		System.out.println(title);
		System.out.println();
		log.info("In SearchResultsPageTitleTest Title of search results page is "+title);
		Assert.assertEquals(title, "New Cars, Used Cars, Car Reviews and News | Cars.com");
		
		}
	@Test//(dependsOnMethods= {"clickOnACheckBox"})
	public void ValidateSecondSearchResultTest() {
		homePage.search();
		String price=searchResults.displaySecondProductPrice();
		System.out.println("price is" + price);
		log.info("In ValidateSecondSearchResultTest Price of Car is " + price);
		Assert.assertNotSame(price, "17000");
	}
	@Test
	public void clickOnACheckBox() {
		homePage.clickOnSearchByBodyStyleLabel();
		homePage.selectAnOptionFromAllBodyStylesDropdown("SUV");
		searchResults=homePage.search();
		WebDriverWait explicitDriver=new WebDriverWait(driver, 30);
		explicitDriver.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='mkId']/ul/li")));

		List<WebElement> checkBoxes=searchResults.listOfCheckboxes();
		System.out.println(checkBoxes.size());
		
		for(int i=0;i<checkBoxes.size();i++) {
			String text=checkBoxes.get(i).getText();
			System.out.println(text);
			if(text.equalsIgnoreCase("Honda")) {
				driver.findElement(By.xpath("//label[@for='mkId-20017']")).click();
				if(!checkBoxes.get(i).isSelected())					
					checkBoxes.get(i).click();
				Assert.assertTrue(checkBoxes.get(i).isSelected());
				break;
			}
		}
				
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
}
