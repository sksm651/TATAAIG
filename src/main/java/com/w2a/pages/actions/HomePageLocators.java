package com.w2a.pages.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageLocators {

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	public WebElement gotoProduct;

	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	public WebElement search;

	// locators for
	@FindBy(xpath = "//span[@id='a-autoid-0-announce']")
	public WebElement sortbyPrice;

	@FindBy(xpath = "//a[@id='s-result-sort-select_2']")
	public WebElement hightolow;

	@FindBy(css = "div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] span[class='a-size-medium a-color-base a-text-normal']")
	public WebElement product;

	@FindBy(xpath = "//p[normalize-space()='128 GB']")
	public WebElement memory;

	@FindBy(xpath = "//img[@alt='Deep Purple']")
	public WebElement colour;

	@FindBy(css = "#add-to-cart-button")
	public WebElement addtocart;

	@FindBy(xpath = "//input[@aria-labelledby='attach-sidesheet-checkout-button-announce']")
	public WebElement checkout;

	@FindBy(css = ".a-price-whole")
	private List<WebElement> priceElements;

	private WebDriver driver;

	public void SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public  List<Integer> getProductPrices() {
		List<Integer> prices = new ArrayList();
		for (WebElement priceElement : priceElements) {
			String priceText = priceElement.getText().replaceAll("[^\\d]", "");
			if (!priceText.isEmpty()) {
				prices.add(Integer.parseInt(priceText));
			}
		}
		return prices;
	}

	public void sortProductPricesDescending() {
		List<Integer> prices = getProductPrices();
		Collections.sort(prices, Collections.reverseOrder());
	}

}
