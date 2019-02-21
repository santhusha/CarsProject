package com.cars.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cars.qa.base.TestBase;

public class SearchResultsPage extends TestBase {
	public SearchResultsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='mkId']/ul/li")
	List<WebElement> checkBoxes;
	
	@FindBy(xpath="(//div[@class='payment-section']/span[1])[2]")
	WebElement secondProductPrice;
	
	public String validateSearchResultsPageTitle() {
		return driver.getTitle();
	}
	public String displaySecondProductPrice() {
		return secondProductPrice.getText();
	}
	
	public List<WebElement> listOfCheckboxes() {
		return checkBoxes;
	}
}
