package com.w2a.pages.actions;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import com.w2a.base.Page;

public class HomePage extends Page {

	// @FindBy (css= ".dropdown-toggle")
	// public WebElement producttab;
	public HomePageLocators home;

	public HomePage() {

		this.home = new HomePageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.home);

	}

	public void gotoProduct() {

		home.gotoProduct.sendKeys("iPhone 14");
		home.search.click();
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

	}

	public HomePage gotoSearchResult() {

		// drpCountry = new
		// Select(driver.findElement(By.xpath("//span[@id='a-autoid-0-announce']")));
		// drpCountry.selectByVisibleText("High to Low");
		home.sortbyPrice.click();
		home.hightolow.click();
		return this;

	}

//	public void sorthightolow() {
//
//		HomePageLocators productPage = new HomePageLocators();
//		List<Integer> priceList = productPage.getProductPrices();
//
//		Collections.sort(priceList, Collections.reverseOrder());
//
//		for (Integer price : priceList) {
//			System.out.println("$" + price);
//		}
//
//	}

	public void booking() {

		System.out.println("Booking start");
		String expectedHeading = "Apple iPhone 14 Pro Max (1 TB) - Gold";
		String heading = home.product.getText();
		if(expectedHeading.equalsIgnoreCase(heading) ) {
		home.product.click();
		}else {
		System.out.println("product not avaliable");
		}

	}

	public void selectConfig() {

		String parentWindowHandle = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(parentWindowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		home.memory.click();
		home.colour.click();
		home.addtocart.click();
		System.out.println("product config done");
		

	}
	
	
	
	public void addTocart() {

		System.out.println("checkout start");
		home.checkout.click();
		
	}
	
	public void arangePrice() {
	
		
		
	}

}
