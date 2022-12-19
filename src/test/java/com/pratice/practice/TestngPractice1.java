package com.pratice.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngPractice1 {
	@BeforeSuite
	public void test1() {
		System.out.println("@BeforeSuite");
	}
	@BeforeClass
	public void test2() {
		System.out.println("@BeforeClass");
	}
	@BeforeMethod
	public void test3() {
		System.out.println("@BeforeMethod");
	}
	
	@BeforeTest
	public void test4() {
		System.out.println("@BeforeTest");
	}
	
	@Test
	public void test5() {
		System.out.println("TestngPractice1->Test5");
	}
	
	@Test 
	public void test6() {
		System.out.println("TestngPractice1->Test6");
	}
	
	@AfterSuite
	public void test7() {
		System.out.println("@After Suite");
	}
	
	@AfterMethod
	public void test8() {
		System.out.println("@AfterMethod");
	}
	
	@AfterClass
	public void test9() {
		System.out.println("@AfterClass");
	}
}
