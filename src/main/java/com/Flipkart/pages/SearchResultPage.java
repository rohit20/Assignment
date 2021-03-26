package com.Flipkart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Flipkart.Base.BaseTest;

public class SearchResultPage extends BaseTest{
	
	//locators

	@FindBy(xpath="//a[@class='_1jJQdf _2Mji8F']")
	WebElement ClickMobile;
	
	@FindBy(xpath="//div[contains(@class, '_3879cV') and text() = 'SAMSUNG']")
	WebElement SamsungCheckbox;
	
	//sort by flipkartassured
	@FindBy(xpath="//img[@class='_3U-Vxu']")
	WebElement Assured;
	
	//Sort by price
	@FindBy(xpath="//div[contains(@class,'_10UF8M') and text() = 'Price -- Low to High']")
	WebElement Price;
	
//	//list 
//	@FindBy(xpath="//div[@class='_4rR01T']")
//	List<WebElement>ProductName;
	
	public SearchResultPage() {
		PageFactory.initElements(driver,this);
	}
	
	//Click Category
	public void clickCategory() {
		
		ClickMobile.click();
	}
	
	//Apply Filters
	public void applyFilters() throws InterruptedException {
		
		SamsungCheckbox.click();
		Thread.sleep(1000);
		Assured.click();
		Price.click();
	}
	//list Names of product
	public void productlistName() {
		
		
		List<WebElement> productName = driver.findElements(By.xpath("//div[@class='_4rR01T']"));

        System.out.println(productName.size());

        for (WebElement webElement : productName) {
            String name = webElement.getText();
            System.out.println(name);
        }
    	}
	//get Product Price
	public void productprice() {
		
		
		List<WebElement> price = driver.findElements(By.xpath("div[@class='_30jeq3 _1_WHN1']"));

        System.out.println(price.size());

        for (WebElement webElement : price) {
            String mobileprice = webElement.getText();
            System.out.println(mobileprice);
        }
    	}
	}
	
	
