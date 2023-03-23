package com.w2a.rough;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.w2a.base.Page;
import com.w2a.pages.actions.HomePage;

public class ProductSearchTab {
	public static void main(String[] args  ) {
		

		
		Page.initConfiguration();
		HomePage home  = new HomePage();
		home.gotoProduct();
		home.gotoSearchResult();
		home.booking();
		home.selectConfig();
		home.addTocart();

		
		
	}

}


