package com.Flipkart.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Flipkart.Base.BaseTest;
import com.Flipkart.pages.HomePage;
import com.Flipkart.pages.SearchResultPage;

public class FlipkartTest extends BaseTest{

	HomePage homePage;
	SearchResultPage searchResult;
	
	public FlipkartTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		setupDriver("browserName");
		homePage= new HomePage();
		searchResult = new SearchResultPage ();
	}
	
	@Test(priority=1)
	public void HomepageValidation() throws InterruptedException{	
		homePage.clickCross();
		Thread.sleep(1000);
		//Verify Title
		String title=homePage.ValidateTitle();
		System.out.print(title);
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	
		//Search Product
		homePage.SearchProduct();
	}
	
	@Test(priority=2)
	public void ApplyFilters() throws InterruptedException{	
		
		HomepageValidation();
		Thread.sleep(2000);
		//Calling category
		searchResult.clickCategory();
		//Applying Filters
		searchResult.applyFilters();
		//get product
		searchResult.productlistName();
		//price
		searchResult.productprice();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

