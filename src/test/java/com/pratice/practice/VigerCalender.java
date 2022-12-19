package com.pratice.practice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VigerCalender {

	public static void main(String[] args) throws Exception {
		String reqMonth="April";
		String reqYear="2024";
		String reqDay="20";
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver:8888/index.php?action=Login&module=Users");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Calendar']")).click();
		driver.findElement(By.xpath("//td/a/img[@src='themes/softed/images/btnL3Calendar.gif']")).click();
		
	String currentMonthYear=driver.findElement(By.xpath("//td[@class='calHdr']//b")).getText();	
	String currentMonth=currentMonthYear.split(" ")[0];
	String currentYear = currentMonthYear.split(" ")[1];
	
	WebDriverWait wait=new WebDriverWait(driver, 10);
	while(!(currentMonth.equals("April") && currentYear.equals("2023"))){
		driver.findElement(By.xpath("//img[@src='themes/images/small_right.gif']")).click();
	
	wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//td[@class='calHdr']//b"), currentMonthYear));
	currentMonthYear=driver.findElement(By.xpath("//td[@class='calHdr']//b")).getText();
	currentMonth=currentMonthYear.split(" ")[0];
	currentYear = currentMonthYear.split(" ")[1];
	}
	driver.findElement(By.xpath("//a[text()='"+reqDay+"']")).click();
	
	
	

	
	}

}
