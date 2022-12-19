package com.pratice.practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {

	public static void main(String[] args)  {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		List<WebElement> listOfLink = driver.findElements(By.xpath("//a"));
		for(int i=0;i<listOfLink.size();i++) {
			String url=listOfLink.get(i).getAttribute("href");
			//url
			try {
			URL u=new URL(url);
			URLConnection urlConnection = u.openConnection();
			
			
			HttpURLConnection httpConnection = (HttpURLConnection)urlConnection;
			int statusCode = httpConnection.getResponseCode();
			if(statusCode!=200) {
				System.out.println("Broken Link ==> " +url+ "==> "+httpConnection.getResponseMessage());
			}
			
		}
			catch(Exception e) {
				System.out.println("Something wrong with this url ==> " +url);
			}

	}

	}}
