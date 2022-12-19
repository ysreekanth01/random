package com.pratice.practice;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgPractice3 {
	@Parameters(value={"browser","username"})
	@Test(groups="sanity")
	public void test1(String browser, String username) {
		Reporter.log("Test 1--> browser name ==>" + browser ,true);
		Reporter.log("Test 1--> username name ==>" + username ,true);
		
	}
	@Parameters(value= {"browser"})
	@Test(groups="sanity")
	public void test2(String browser) {
		Reporter.log(browser);
	}
}
