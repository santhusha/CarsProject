package com.cars.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cars.qa.base.TestBase;

public class HomePage extends TestBase {
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//label[@for='hswBodyStyle']")
	WebElement searchByBodyStyle;
	
	@FindBy(name="bodyStyle")
	WebElement dropdown;
	
	@FindBy(xpath="//div[@class='_12IWL']/input")
	WebElement zipcode;
	
	@FindBy(className="NZE2g")
	WebElement searchButton;
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public void clickOnSearchByBodyStyleLabel() {
		searchByBodyStyle.click();
	}
	
	public void selectAnOptionFromAllBodyStylesDropdown(String desiredOption) {
		Select select = new Select(dropdown);
		//select.selectByVisibleText(desiredOption);
		List<WebElement> dropdownlist=select.getOptions();
		System.out.println(dropdownlist.size());
		for(int i=0;i<dropdownlist.size();i++) {
			String option=dropdownlist.get(i).getText();
			if(option.equals(desiredOption)) {
				select.selectByIndex(i);
			}
		}
	}
	
	public String validateZipcodeValue() {
		return zipcode.getText();
	}
	
	public SearchResultsPage search() {
		searchButton.click();
		return new SearchResultsPage();		
	}
}
