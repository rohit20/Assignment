package com.Flipkart.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Flipkart.Base.BaseTest;

public class HomePage extends BaseTest{

	//PageFactory
		@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
		WebElement CloseLoginPopup;
		
		@FindBy(xpath="//input[@type='text']")
		WebElement Searchbar;
		
		public HomePage() {
			PageFactory.initElements(driver,this);
		}

		//Validate Cross
		public void clickCross() {
			CloseLoginPopup.click();
		}
		public String ValidateTitle() {
			return driver.getTitle();
		}
		public void SearchProduct() {
			Searchbar.sendKeys("Samsung Galaxy S10");
			Searchbar.sendKeys(Keys.ENTER);
		}

		
}
