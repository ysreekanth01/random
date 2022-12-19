package com.pratice.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartDiscount {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/offers-store?otracker=nmenu_offer-zone&fm=neo%2Fmerchandising&iid=M_5f9936b7-ee87-4ee4-8ae6-30845138903a_1_372UD5BXDFYS_MC.G6ZC4RAJ9OHU&otracker=hp_rich_navigation_8_1.navigationCard.RICH_NAVIGATION_Top%2BOffers_G6ZC4RAJ9OHU&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_8_L0_view-all&cid=G6ZC4RAJ9OHU");
		String partialXpath="//div[contains(text(),'70% off')]";
		String expectedValue;

	}

}
