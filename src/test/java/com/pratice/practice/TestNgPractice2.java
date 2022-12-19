package com.pratice.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgPractice2 {
	@BeforeSuite
	public void test1() {
		System.out.println("TestNgPractice2-->@BeforeSuite");
	}
	@BeforeClass
	public void test2() {
		System.out.println("TestNgPractice2-->@BeforeClass");
	}
	@BeforeMethod
	public void test3() {
		System.out.println("TestNgPractice2-->	@BeforeMethod");
	}
	
	@BeforeTest
	public void test4() {
		System.out.println("TestNgPractice2-->@BeforeTest");
	}
	
	@Test
	public void test5() {
		System.out.println("TestngPractice2->Test5");
	}
	
	@Test 
	public void test6() {
		System.out.println("TestngPractice2->Test6");
	}
	
	@AfterSuite
	public void test7() {
		System.out.println("TestNgPractice2-->@After Suite");
	}
	
	@AfterTest
	public void test10() {
		System.out.println("TestNgPractice2-->@AfterTest");
	}
	@AfterMethod
	public void test8() {
		System.out.println("TestNgPractice2-->@AfterMethod");
	}
	
	@AfterClass
	public void test9() {
		System.out.println("TestNgPractice2-->@AfterClass");
	}

}
